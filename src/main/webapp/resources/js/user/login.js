$(function () {

    var loginUrl='/cdqblog/userlogin';

    $('.tishi').hide();

    $('#btn-login').click(function () {
       login();
    });

    $('.user input').focus(function () {
        $('.user input').css("border-style","none");
        $('#tishi-username').hide();
    });
    $('.user-in input').focus(function () {
        $('.user-in input').css("border-style","none");
        $('#tishi-password').hide();
    });

    if (sessionStorage.getItem('cdq_blog_info')!=null){
        confirm("加载中。。。。")
        window.location.href='/cdqblog/index';
    }

    function login() {
        var un=$('.user input').val();
        var pw=$('.user-in input').val();
        if (un==''){
            $('.user input').css({"border-color":"red","border-style":"solid"});
            $('#tishi-username').show();
            return;
        }
        if (pw==''){
            $('.user-in input').css({"border-color":"red","border-style":"solid"});
            $('#tishi-password').show();
            return;
        }
        // loginUrl.append('username='+)
        // loginUrl=loginUrl+'username='+un+'&&'+'password='+pw;
        $.ajax({
           url:loginUrl,
           type:'POST',
            data:{
               username:un,
                password:pw
            },
            dataType:'JSON',
            success:function (data) {
                if (data.success){
                    var user=JSON.stringify(data.userInfo)
                    sessionStorage.setItem('cdq_blog_info',user);
                    alert("登陆成功");
                    window.location.href='/cdqblog/index';
                } else {
                    alert(data.errMsg);
                }
            }
        });
    }

});