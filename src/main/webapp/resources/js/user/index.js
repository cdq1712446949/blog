$(function () {
    var firstArticleTypeListUrl = '/cdqblog/firstarticletypelist';
    var advertisementListUrl = '/cdqblog/advertismentlist';
    var noticeListUrl = '/cdqblog/noticelist';
    var articleListUrl = '/cdqblog/article/getarticlelist';
    var userLevelUrl = '/cdqblog/getuserlevellist'

    var size = 0;
    var images;

    function getUserInfo() {
        var user = sessionStorage.getItem('cdq_blog_info');
        var tempHtml = '';
        if (user != null) {
            tempHtml = user.nickName;
            $('.user-info').hide();
        }
    }

    getUserInfo();

    function getUserLevelList() {
        $.getJSON(userLevelUrl, function (data) {
            if (data.success) {
                var list=JSON.stringify(data.userLevelList)
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
                var tempHtml = '';
                $.each(firstArticleTypeList, function (index, item) {
                    tempHtml += '<li><a href=" '
                        + '#'
                        + '">'
                        + item.articleTypeName
                        + '</a></li>';
                });
                $('.left-tools-ul').html(tempHtml);
            } else {
                alert("获取一级文章类别失败，" + data.errMsg);
            }
        })
    }

    getFirstArticleTypeList();

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
        $.getJSON(articleListUrl, function (data) {
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
                        + '</a><a href="#" style="float: right"> <img src=" resources/img/comment.png" style="width: 20px;height: 20px;">'
                        + item.commentNum
                        + '</a><a href="#" style="float: right"> <img src=" resources/img/zan.png" style="width: 20px;height: 20px;">'
                        + item.goodNum
                        + '&nbsp; &nbsp;</a></div></div>';
                });
                $('#article').html(tempHtml);

            } else {
                alert("获取文章列表失败，" + data.errMsg);
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
        console.log('play:' + lunbo_index)
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
        console.log('left:' + lunbo_index);
        var ss = $("#lunbo a").length;
        $(".lunbo a ").eq(lunbo_index).fadeIn(1000).siblings().fadeOut(1000); // siblings  找到 兄弟节点(不包括自己）必须要写

    }

    function toright() {
        lunbo_index++;
        if (lunbo_index > size) //判断index<0的情况为：开始点击#toright  index=0时  再点击 #toleft 为负数了 会出错
        {
            lunbo_index = 0;
        }
        console.log('left:' + lunbo_index);
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
