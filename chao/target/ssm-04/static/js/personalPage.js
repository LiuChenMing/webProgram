$(function () {



    $("#myInfo").click(function(){
        $("#addFrame").attr("src","./basicInfo.html");
    });

    $("#releaseGoods").click(function () {
        $("#addFrame").attr("src","./releaseGoods.html");
    })

    $("#myGoods").click(function () {
        $("#addFrame").attr("src","./myGoods.html");
    })

    $(".link").click(function () {
        $(".link").css("color","darkgrey");
        $(this).css("color","white");
    })



    $("#logout").click(function () {
        //清除本地name为userId的cookie
        $.removeCookie("userId",{ path: '/chao' });
        //清除localStorage中key为loginInfo的值
        window.localStorage.clear();

        window.location.href="/chao/index.html";
    })


//设置登录名
    var m=JSON.parse(window.localStorage.getItem("loginInfo"));
    var nowTime=new Date().getTime();
    if(nowTime-m.time<2*60*60*1000){
        $("#userName").text(m.Information.nickname);
    }
})