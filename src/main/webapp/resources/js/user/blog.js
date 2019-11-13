$(function () {

    var zan_status = 0;//当前登陆用户是否点赞过该文章,0没有，1有
    var collection_status = 0;//当前登陆用户是否收藏了该文章，0没有，1有
    var articleUrl = '/cdqblog/article/getarticlebyid';
    var thumbsUrl = '/cdqblog/iszanorcollection';
    var authorInfoUrl = '/cdqblog/getuserinfobyid';
    var newArticleUrl = '/cdqblog/article/getnewarticlebyuserid';
    var collectionUrl='/cdqblog/usercollectionmanage/';
    var thumbsUpUrl='/cdqblog/thumbsupmanage';

    var authorId = '';
    var userId = '';
    var articleId = '';

    var isCollection = false; //是否收藏了该文章
    var isThumbsUp = false; //是否点赞了该文章
    var colStatus=0;
    var thumbsStatus=0;

    function getUserInfo() {
        var u = JSON.parse(sessionStorage.getItem('cdq_blog_info'));
        var tempHtml = '';
        var imgHtml = '';
        // var p=u.userId;
        if (u != null) {
            userId = u.userId;
            tempHtml += '<ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">\n'
                + '<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">'
                + '<img src="'
                + '/cdqblog'
                + u.userHeadPhoto
                + '"><span>'
                + u.nickName
                + '</span></a>'
                + '<ul class="dropdown-menu">'
                + '<li><a href="/cdqblog/personinfomanage" data-id="attention">我的关注</a></li>'
                + '<li><a href="/cdqblog/personinfomanage" data-id="collection">我的收藏</a></li>'
                + '<li><a href="/cdqblog/personinfomanage" data-id="personinfo">个人中心</a></li>'
                + '<li><a href="/cdqblog/personinfomanage" data-id="config">账号设置</a></li>'
                + '<li><a id="logout">退出登录</a></li>'
                + '</ul></li></ul>';
            imgHtml += '<img class="avatar" src="'
                + '/cdqblog'
                + u.userHeadPhoto
                + '"/>';
            $('.user-info').html(tempHtml);
            $('.comment-title').html(imgHtml);
            $('.user-info').show();
            $('.login-regist').hide();
            $('.comment-signarea').hide();
            $('#comment-form').show();
        }
    }

    getUserInfo();

    //解析地址,获取参数json对象
    function resolvUrl() {
        var href = window.location.href;
        console.log(window.location.href);
        var arr1 = href.split('?');
        var result = '{';
        if (arr1.length <= 1) {
            return null;
        } else {
            var arr2 = arr1[1].split('&&');
            for (var i = 0; i < arr2.length; i++) {
                var tempArr = arr2[i].split('=');
                if (tempArr.length == 2) {
                    result += '"' + tempArr[0] + '"' + ':' + tempArr[1]
                    if (i < arr2.length - 1) {
                        result += ',';
                    }
                }
            }
            result += '}';
            return JSON.parse(result);
        }
    }

    function getarticle() {
        var premeters = resolvUrl();
        articleId = premeters.articleId;
        $.ajax({
            url: articleUrl,
            type: 'POST',
            data: {
                articleId: articleId
            },
            dataType: 'JSON',
            success: function (data) {
                if (data.success) {
                    var article = data.article;
                    var lableList = article.articleLableList;
                    var articleType = article.articleType;
                    var author = article.user;
                    authorId = author.userId;
                    var headHtml = '<img src="/cdqblog'
                        + author.userHeadPhoto
                        + '" style="height: 50px;width: 50px;margin: 0 0 0 10px;">';
                    var lableHtml = '<span>文章标签：</span>';
                    for (var i = 0; i < lableList.length; i++) {
                        var lable = lableList[i];
                        lableHtml += '<a href="#" class="a-blue">'
                            + lable.articleLableName
                            + '</a>';
                    }
                    $('#author-head').html(headHtml);
                    $('#nick-name').html(author.nickName);
                    $('#level').html('等级:' + calLevel(author.userExprience));
                    $('#article-title').html(article.articleTitle);
                    $('#article-info').html(article.articleCreateTime + ' &nbsp;&nbsp;' + '阅读数:' + article.lookNum);
                    $('.article-tags').html(lableHtml);
                    $('#article').html(article.articleContent);
                    codeHight();
                    getAuthorInfo();
                } else {
                    alert("获取文章失败：" + data.errMsg);
                }
            }
        });
    }

    getarticle();

    function getAuthorInfo() {
        $.ajax({
            url: authorInfoUrl,
            type: 'GET',
            data: {
                userId: authorId
            },
            dataType: 'JSON',
            success: function (data) {
                if (data.success) {
                    var userInfo = data.userInfo;
                    var html = ' <div id="blog-num" class="ffff"><a href="#">博客</a> <br><span>'
                        + userInfo.blogNum
                        + '</span></div><div id="fans-num" class="ffff"><a href="#">粉丝</a> <br><span>'
                        + userInfo.funsNum
                        + '</span></div><div id="look-num" class="ffff"><a href="#">浏览</a> <br><span>'
                        + userInfo.userLookNum
                        + '</span></div><div id="comment-num" class="ffff"><a href="#">评论</a> <br><span>'
                        + userInfo.commentNum
                        + '</span></div>';
                    $('.auther-two').html(html);
                    getNewArticleList();
                } else {
                    alert("获取作者信息失败:" + data.errMsg);
                }
            }
        })
    }

    function getNewArticleList() {
        $.ajax({
            url: newArticleUrl,
            type: 'GET',
            data: {
                userId: authorId
            },
            dataType: 'JSON',
            success: function (data) {
                if (data.success) {
                    var newArticleList = data.newArticleList;
                    var html = '';
                    for (var i = 0; i < newArticleList.length; i++) {
                        var temp = newArticleList[i];
                        html += '<li><a href="/cdqblog/blogcontent?articleId='
                            + temp.articleId
                            + '">'
                            + temp.articleTitle
                            + '</a></li>';
                    }
                    $('#new-article-ul').html(html);
                    getThumbsStatus();
                } else {
                    alert("获取最新文章失败：" + data.errMsg);
                }
            }
        })
    }

    function getThumbsStatus() {
        $.ajax({
            url: thumbsUrl,
            type: 'GET',
            data: {
                userId: userId,
                articleId: articleId
            },
            dataType: 'JSON',
            success: function (data) {
                if (data.success) {
                    var thumbsCollection = data.thumbsCollection;
                    if (thumbsCollection.isCollection == 0) {
                        isCollection = true;
                        colStatus=-1;
                    }
                    if (thumbsCollection.isCollection == -1) {
                        isCollection=false;
                        colStatus=0;
                    }
                    if (thumbsCollection.isThumbsUp == 0) {
                        isThumbsUp = true;
                        thumbsStatus=-1;
                    }
                    if (thumbsCollection.isThumbsUp == -1) {
                        isThumbsUp=false;
                        thumbsStatus=0
                    }
                    if (isCollection){
                        $('#shoucang').css({'background':'url(resources/img/re-shoucang.png) no-repeat','background-size':'30px'});
                    }else{
                        $('#shoucang').css({'background':'url(resources/img/shoucang.png) no-repeat','background-size':'30px'});
                    }
                    if (isThumbsUp){
                        $('#dianzan').css({'background':'url(resources/img/re-zan.png) no-repeat','background-size':'30px'});
                    }else {
                        $('#dianzan').css({'background':'url(resources/img/zan.png) no-repeat','background-size':'30px'});
                    }
                } else {
                    alert('获取失败：' + data.errMsg);
                }
            }
        });
    }

    //点赞以及收藏管理
    function tcManage(url,status) {
        // alert("sssss");
        $.ajax({
            url:url,
            type:"GET",
            data:{
                articleId:articleId,
                userId:userId,
                status:status
            },
            dataType:"JSON",
            success:function (data) {
                if (data.success){
                    getThumbsStatus();
                } else {
                    alert('操作失败'+data.errMsg);
                }
            }
        })
    }
    //
    $('#dianzan').click(function () {
        tcManage(thumbsUpUrl,thumbsStatus)
    });
    $('#shoucang').click(function () {
        tcManage(collectionUrl,colStatus)
    });

    <!--代码高亮-->
    //初始化方法
    //highlightBlock(block)
    // 应用高亮到一个包含代码的DOM节点上
    //
    // initHighlighting()
    // 在页面的<pre><code>..</code></pre>区域上应用高亮
    //
    // initHighlightingOnLoad()
    // 绑定高亮到页面加载事件上
    function codeHight() {
        // hljs.initHighlightingOnLoad();
        var allpre = document.getElementsByTagName("pre");
        for (i = 0; i < allpre.length; i++) {
            var onepre = document.getElementsByTagName("pre")[i];
            var mycode = document.getElementsByTagName("pre")[i].innerHTML;
            onepre.innerHTML = '<code id="mycode">' + mycode + '</code>';
        }
        hljs.initHighlighting();
    }

    function calLevel(exprience) {
        var userLevelList = JSON.parse(localStorage.getItem('user_level_list'));
        var levelName = '屌丝';
        var levelId = '1';
        for (var i = 0; i < userLevelList.length; i++) {
            var userLvel = userLevelList[i];
            if (exprience < userLvel.userLevelExprience) {
                return levelName + '(' + levelId + ')';
            }
            levelName = userLvel.userLevelName;
            levelId = userLvel.userLevelId;
        }
    }

    $('#attention').click(function () {
        alert("不想做了");
    });

    // codeHight();

});


