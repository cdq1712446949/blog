$(function () {
    var firstArticleTypeListUrl = '/cdqblog/firstarticletypelist';
    var advertisementListUrl = '/cdqblog/advertismentlist';
    var noticeListUrl = '/cdqblog/noticelist';
    var articleListUrl = '/cdqblog/article/getarticlelist';
    var userLevelUrl = '/cdqblog/getuserlevellist';
    var articleTypeUrl = '/cdqblog/getarticletypelist'

    var size = 0;
    var images;

    var pageSize = 6;
    var pageIndex = 1;
    var sortColumn = 1;
    var ad = 'desc';
    var articleTypeId = '-1';
    var parentArticleTypeId = '-1';
    var createTime = '';
    var keyWord = '';

    var isSearch = false;

    function getUserInfo() {
        var u = JSON.parse(sessionStorage.getItem('cdq_blog_info'));
        var tempHtml = '';
        // var p=u.userId;
        if (u != null) {
            tempHtml += '<ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">\n'
                + '<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">'
                + '<img src="'
                + '/cdqblog'
                + u.userHeadPhoto
                + '"><span>'
                + u.nickName
                + '</span></a>\n'
                + '<ul class="dropdown-menu">'
                + '<li><a href="#">我的关注</a></li>'
                + '<li><a href="#">我的收藏</a></li>'
                + '<li><a href="#">个人中心</a></li>'
                + '<li><a href="#">账号设置</a></li>'
                + '<li><a href="#">退出登录</a></li>'
                + '</ul></li></ul>';
            $('.user-info').html(tempHtml);
            $('.user-info').show();
            $('.login-regist').hide();
        }
    }

    getUserInfo();

    $('.user-info').hover(function () {
        $('#user-info-menu').show();
    });
    $('#user-info-menu').mouseleave(function () {
        $('#user-info-menu').hide();
    });

    //添加清除用户等级列表方法（记录修改后）
    function getUserLevelList() {
        $.getJSON(userLevelUrl, function (data) {
            if (data.success) {
                var list = JSON.stringify(data.userLevelList)
                localStorage.setItem("user_level_list", list);
            } else {
                console.log("获取用户等级列表失败:" + data.errMsg)
            }
        });
    }

    if (localStorage.getItem('user_level_list') == null) {
        getUserLevelList();
    }

    function getAdvertisement() {
        $.getJSON(advertisementListUrl, function (data) {
            if (data.success) {
                var advertisementList = data.advertisementList;
                var tempHtml = '';
                var tempUlHtml = '';
                $.each(advertisementList, function (index, item) {
                    // <a href="#"><img src="http://www.jq22.com/img/cs/500x300a.png"></a>
                    tempHtml += '<a href=" '
                        + item.advertisementHref
                        + '" target="_blank">'
                        + '<img src="'
                        + item.advertisementPhoto
                        + '">'
                        + '</a>';
                    tempUlHtml += '<li></li>';
                });
                $('.lunbo').html(tempHtml);
                size = $('.lunbo a').length;
                images = $('.lunbo a');
                // $('#lunbo-ul').html(tempUlHtml);
            } else {
                alert("获取广告列表失败," + data.errMsg);
            }
        })
    }

    getAdvertisement();

    function getFirstArticleTypeList() {
        $.getJSON(firstArticleTypeListUrl, function (data) {
            if (data.success) {
                var firstArticleTypeList = data.firstArticleTypeList;
                sessionStorage.setItem('firstArticleType', JSON.stringify(firstArticleTypeList));
                var tempHtml = '';
                $.each(firstArticleTypeList, function (index, item) {
                    tempHtml += '<li><a class="first-type" typeId="'
                        + item.articleTypeId
                        + '">'
                        + item.articleTypeName
                        + '</a></li>';
                });
                $('.left-tools-ul').html(tempHtml);
                $('.first-type').click(function () {
                    hs(this);
                });
            } else {
                alert("获取一级文章类别失败，" + data.errMsg);
            }
        })
    }

    getFirstArticleTypeList();

    //隐藏轮播图以及公告，展示组合查询条件
    function hs(dom) {
        if (!isSearch) {
            $('.banner').hide();
            $('.gonggao').hide();
            $('.condition').show();
            isSearch = true;
            var tempList = JSON.parse(sessionStorage.getItem("firstArticleType"));
            var tempHtml = '';
            for (var i = 0; i < tempList.length; i++) {
                var temp = tempList[i];
                tempHtml += ' <li><a typeId="'
                    + temp.articleTypeId
                    + '" status="-1" class="typeId">'
                    + temp.articleTypeName
                    + '</a></li>';
            }
            $('#fir-type-ul').html(tempHtml);
            $('.typeId').click(function () {
                var status = this.getAttribute('status');
                if (status == '0') {
                    this.setAttribute('status', '-1');
                    parentArticleTypeId = '-1';
                    getArticleList();
                    $('#type-ul').html('');
                    // alert('改编为-1');
                }
                if (status == '-1') {
                    this.setAttribute('status', 0);
                    parentArticleTypeId = this.getAttribute('typeId');
                    getArticleType();
                    getArticleList();
                }
                var liArr = $('.typeId');
                for (var i = 0; i < liArr.length; i++) {
                    var temp = liArr[i];
                    if (temp.getAttribute('typeId') == parentArticleTypeId) {
                        temp.setAttribute("style","background-color: #00CCFF;");
                    }else {
                        temp.setAttribute("style","background-color: none;");
                        temp.setAttribute('status','-1');
                    }
                }
                // alert('改变为0');
            });
        }
        parentArticleTypeId = dom.getAttribute('typeId');
        getArticleType();
        getArticleList();
        var liArr2 = $('.typeId');
        for (var j = 0; j < liArr2.length; j++) {
            var temp = liArr2[j];
            if (temp.getAttribute('typeId') == parentArticleTypeId) {
                temp.setAttribute('status','0');
                temp.setAttribute("style","background-color: #00CCFF;");
            }else {
                temp.setAttribute("style","background-color: none;");
                temp.setAttribute('status','-1');
            }
        }
    }

    function getArticleType(){
        $.ajax({
            url:articleTypeUrl,
            type:'GET',
            data:{
                parentId:parentArticleTypeId
            },
            dataType:'JSON',
            success:function (data) {
                if (data.success){
                    var tempHtml='';
                    var articleTypeList=data.articleTypeList;
                    $.each(articleTypeList,function (index,item) {
                        tempHtml+=' <li><a typeId="'
                            + item.articleTypeId
                            + '" status="-1" class="type-id">'
                            + item.articleTypeName
                            + '</a></li>';
                    });
                    $('#type-ul').html(tempHtml);
                    $('.type-id').click(function () {
                        typeClick(this);
                    });
                } else{
                    alert("获取二级文章类型列表失败:"+e.errMsg);
                }
            }
        })
    }

    function typeClick(dom) {
        var status=dom.getAttribute('status');
        if (status=='-1') {
            dom.setAttribute('status','0');
            articleTypeId = dom.getAttribute('typeId');
            getArticleList();
        }
        if (status=='0'){
            articleTypeId='-1';
            dom.setAttribute('status','-1');
            getArticleList();
        }
        var liArr = $('.type-id');
        for (var i = 0; i < liArr.length; i++) {
            var temp = liArr[i];
            if (temp.getAttribute('typeId') == articleTypeId) {
                temp.setAttribute("style","background-color: #00CCFF;");
            }else {
                temp.setAttribute("style","background-color: none;");
                temp.setAttribute('status','-1');
            }
        }
    }

    $('#creatime-input').on(" input propertychange",function(){
        createTime=this.value;
        getArticleList();
    });
    $('#condition-search').on(" input propertychange",function(){
        keyWord=this.value;
        getArticleList();
    });
    function createTimeClick(dom) {
        alert(dom.val());
    }
    
    function getNoticeList() {
        $.getJSON(noticeListUrl, function (data) {
            if (data.success) {
                var noticeList = data.noticeList;
                var tempHtml = '';
                $.each(noticeList, function (index, item) {
                    tempHtml += item.noticeContent;
                });
                $('#notice').html(tempHtml);
            } else {
                alert("获取公告列表失败，" + data.errMsg);
            }
        })
    }

    getNoticeList();

    function getArticleList() {
        $.ajax({
            url: articleListUrl,
            type: 'GET',
            data: {
                pageSize: pageSize,
                pageIndex: pageIndex,
                sortColumn: sortColumn,
                ad: ad,
                createTime: createTime,
                keyWord: keyWord,
                parentArticleTypeId: parentArticleTypeId,
                articleTypeId: articleTypeId
            },
            dataType: 'JSON',
            success: function (data) {
                if (data.success) {
                    var articleList = data.articleList;
                    var tempHtml = '';
                    $.each(articleList, function (index, item) {
                        tempHtml += '<div class="article"> <a href="/cdqblog/blogcontent?articleId='
                            + item.articleId
                            + '">'
                            + item.articleTitle
                            + '</a> </br>  <p style="overflow: hidden;text-overflow:ellipsis;white-space: nowrap;">'
                            + item.articleDiscription
                            + '</p> <div class="article-bottom"><div class="yuan" style="background-color: white"><img src="'
                            + 'resources/img/weixin.png'
                            + '"></div><a href="#" style="font-size: 14px">'
                            + item.user.nickName
                            + '</a><a style="float: right"> <img src=" resources/img/comment.png" style="width: 20px;height: 20px;">'
                            + item.commentNum
                            + '</a><a style="float: right"> <img src=" resources/img/zan.png" style="width: 20px;height: 20px;">'
                            + item.goodNum
                            + '&nbsp; &nbsp;</a></div></div>';
                    });
                    $('#article').html(tempHtml);
                } else {
                    // alert("获取文章列表失败，" + data.errMsg);
                }
            }
        })
    }

    getArticleList();


    $(".erweima-weixin").hide();
    //支付宝点击事件
    $("#zhifubao").click(function () {
        $(".erweima-weixin").hide();
        $(".erweima-zhifubao").show();
    });
    //微信点击事件
    $("#weixin").click(function () {
        $(".erweima-weixin").show();
        $(".erweima-zhifubao").hide();
    });
    ///轮播

    //$("#toright").hide();
    //$("#toleft").hide();
    $('#toright').hover(function () {
        $("#toleft").hide()
    }, function () {
        $("#toleft").show()
    })
    $('#toleft').hover(function () {
        $("#toright").hide()
    }, function () {
        $("#toright").show()
    })

    var t;
    var lunbo_index = 0;
/////自动播放
    t = setInterval(play, 5000);

    function play() {
        lunbo_index++;
        if (lunbo_index > size) {
            lunbo_index = 0
        }
        // console.log('play:' + lunbo_index)
        $("#lunbobox ul li").eq(lunbo_index).css({
            "background": "#999",
            "border": "1px solid #ffffff"
        }).siblings().css({
            "background": "#cccccc",
            "border": ""
        });

        $(".lunbo a ").eq(lunbo_index).fadeIn(1000).siblings().fadeOut(1000);
    };

    function toleft() {
        lunbo_index--;
        if (lunbo_index <= 0) //判断index<0的情况为：开始点击#toright  index=0时  再点击 #toleft 为负数了 会出错
        {
            lunbo_index = size;
        }
        // console.log('left:' + lunbo_index);
        var ss = $("#lunbo a").length;
        $(".lunbo a ").eq(lunbo_index).fadeIn(1000).siblings().fadeOut(1000); // siblings  找到 兄弟节点(不包括自己）必须要写

    }

    function toright() {
        lunbo_index++;
        if (lunbo_index > size) //判断index<0的情况为：开始点击#toright  index=0时  再点击 #toleft 为负数了 会出错
        {
            lunbo_index = 0;
        }
        // console.log('left:' + lunbo_index);
        $(".lunbo a ").eq(lunbo_index).fadeIn(100).siblings().fadeOut(100); // siblings  找到 兄弟节点(不包括自己）必须要写

    }

    //上一张、下一张切换
    $("#toleft").click(function () {
        toleft();
    });

    $('#toright').click(function () {
        toright();
    })

});
