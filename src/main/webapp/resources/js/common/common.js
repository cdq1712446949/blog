$(function () {

    //解析地址,获取参数json对象
    function resolvUrl() {
        var href = window.location.href;
        console.log(window.location.href);
        var arr1 = href.split('?');
        var result='{';
        if (arr1.length <= 1) {
            return null;
        } else {
            var arr2 = arr1[1].split('&&');
            for (var i=0;i<arr2.length;i++){
                var tempArr=arr2[i].split('=');
                if (tempArr.length==2){
                    result+='"'+tempArr[0]+'"'+':'+tempArr[1]
                    if (i<arr2.length-1){
                        result+=',';
                    }
                }
            }
            result+='}';
            return JSON.parse(result);
        }
    }

    $('#logo').click(function () {
        window.location.href='/cdqblog/index';
    });

});