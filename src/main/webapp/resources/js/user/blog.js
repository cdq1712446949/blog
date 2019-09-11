$(function () {

    var zan_status=0;//当前登陆用户是否点赞过该文章,0没有，1有
    var collection_status=0;//当前登陆用户是否收藏了该文章，0没有，1有

    function getUserInfo() {
        var u = JSON.parse(sessionStorage.getItem('cdq_blog_info'));
        var tempHtml = '';
        var imgHtml='';
        // var p=u.userId;
        if (u != null) {
            tempHtml += '<ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">\n'
                + '<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">'
                + '<img src="'
                + '/cdqblog'
                + u.userHeadPhoto
                + '"><span>'
                + u.nickName
                + '</span></a>'
                + '<ul class="dropdown-menu">'
                +'<li><a href="#">我的关注</a></li>'
                +'<li><a href="#">我的收藏</a></li>'
                +'<li><a href="#">个人中心</a></li>'
                +'<li><a href="#">账号设置</a></li>'
                +'<li><a href="#">退出登录</a></li>'
                + '</ul></li></ul>';
            imgHtml+='<img class="avatar" src="'
                +'/cdqblog'
                +u.userHeadPhoto
                +'"/>';
            $('.user-info').html(tempHtml);
            $('.comment-title').html(imgHtml);
            $('.user-info').show();
            $('.login-regist').hide();
            $('.comment-signarea').hide();
            $('#comment-form').show();
        }
    }

    getUserInfo();

    function getarticle(){

    }

});