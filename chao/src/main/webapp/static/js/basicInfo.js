$(function(){

    $("#nicknameAlter").click(function () {
        var name=$("#nickname").text();
        $("#nicknameText").val(name);

        $("#nicknameSpan1 > *").css("display","none");
        $("#nicknameSpan2 > *").css("display","inline");
        $("#nicknameCancel").click(function () {
            $("#nicknameSpan1 > *").css("display","inline");
            $("#nicknameSpan2 > *").css("display","none");
        });
        $("#nicknameSave").click(function () {
            var u={nickname:$("#nicknameText").val(),userId:$("#userId").text()};
            $.get("/chao/user/userUpdate",u,function (data, status) {
                if(data=="true"){
                    $("#nickname").text(u.nickname);
                }
                else{
                    alert("修改出错");
                }

            });
            $("#nicknameSpan1 > *").css("display","inline");
            $("#nicknameSpan2 > *").css("display","none");
        });
    })

    $("#passwordAlter").click(function () {
        var name=$("#password").text();
        $("#passwordText").val(name);

        $("#passwordSpan1 > *").css("display","none");
        $("#passwordSpan2 > *").css("display","inline");
        $("#passwordCancel").click(function () {
            $("#passwordSpan1 > *").css("display","inline");
            $("#passwordSpan2 > *").css("display","none");
        });
        $("#passwordSave").click(function () {
            var u={password:$("#passwordText").val(),userId:$("#userId").text()};
            $.get("/chao/user/userUpdate",u,function (data, status) {
                if(data=="true"){
                    alert("修改成功")
                }
                else{
                    alert("修改出错");
                }

            });
            $("#passwordSpan1 > *").css("display","inline");
            $("#passwordSpan2 > *").css("display","none");
        });
    })

    $("#emailAlter").click(function () {
        var name=$("#email").text();
        $("#emailText").val(name);

        $("#emailSpan1 > *").css("display","none");
        $("#emailSpan2 > *").css("display","inline");
        $("#emailCancel").click(function () {
            $("#emailSpan1 > *").css("display","inline");
            $("#emailSpan2 > *").css("display","none");
        });
        $("#emailSave").click(function () {
            var u={email:$("#emailText").val(),userId:$("#userId").text()};
            $.get("/chao/user/userUpdate",u,function (data, status) {
                if(data=="true"){
                    $("#email").text(u.email);
                }
                else{
                    alert("修改出错");
                }

            });
            $("#emailSpan1 > *").css("display","inline");
            $("#emailSpan2 > *").css("display","none");
        });
    })

    $("#alipayIdAlter").click(function () {
        var name=$("#alipayId").text();
        $("#alipayIdText").val(name);

        $("#alipayIdSpan1 > *").css("display","none");
        $("#alipayIdSpan2 > *").css("display","inline");
        $("#alipayIdCancel").click(function () {
            $("#alipayIdSpan1 > *").css("display","inline");
            $("#alipayIdSpan2 > *").css("display","none");
        });
        $("#alipayIdSave").click(function () {
            var u={email:$("#alipayIdText").val(),userId:$("#userId").text()};
            $.get("/chao/user/userUpdate",u,function (data, status) {
                if(data=="true"){
                    $("#alipayId").text(u.email);
                }
                else{
                    alert("修改出错");
                }

            });
            $("#alipayIdSpan1 > *").css("display","inline");
            $("#alipayIdSpan2 > *").css("display","none");
        });
    })

    $("#genderAlter").click(function () {
        var name=$("#gender").text();
        $("#genderText").val(name);

        $("#genderSpan1 > *").css("display","none");
        $("#genderSpan2 > *").css("display","inline");
        $("#genderCancel").click(function () {
            $("#genderSpan1 > *").css("display","inline");
            $("#genderSpan2 > *").css("display","none");
        });
        $("#genderSave").click(function () {
            var u={gender:$("#genderText").val(),userId:$("#userId").text()};
            $.get("/chao/user/userUpdate",u,function (data, status) {
                if(data=="true"){
                    $("#gender").text(u.gender);
                }
                else{
                    alert("修改出错");
                }

            });
            $("#genderSpan1 > *").css("display","inline");
            $("#genderSpan2 > *").css("display","none");
        });
    })

    $("#addressAlter").click(function () {
        var name=$("#address").text();
        $("#addressText").val(name);

        $("#addressSpan1 > *").css("display","none");
        $("#addressSpan2 > *").css("display","inline");
        $("#addressCancel").click(function () {
            $("#addressSpan1 > *").css("display","inline");
            $("#addressSpan2 > *").css("display","none");
        });
        $("#addressSave").click(function () {
            var u={address:$("#addressText").val(),userId:$("#userId").text()};
            $.get("/chao/user/userUpdate",u,function (data, status) {
                if(data=="true"){
                    $("#address").text(u.address);
                }
                else{
                    alert("修改出错");
                }

            });
            $("#addressSpan1 > *").css("display","inline");
            $("#addressSpan2 > *").css("display","none");
        });
    })

    $("#ageAlter").click(function () {
        var name=$("#age").text();
        $("#ageText").val(name);

        $("#ageSpan1 > *").css("display","none");
        $("#ageSpan2 > *").css("display","inline");
        $("#ageCancel").click(function () {
            $("#ageSpan1 > *").css("display","inline");
            $("#ageSpan2 > *").css("display","none");
        });
        $("#ageSave").click(function () {
            var u={age:$("#ageText").val(),userId:$("#userId").text()};
            $.get("/chao/user/userUpdate",u,function (data, status) {
                if(data=="true"){
                    $("#age").text(u.age);
                }
                else{
                    alert("修改出错");
                }

            });
            $("#ageSpan1 > *").css("display","inline");
            $("#ageSpan2 > *").css("display","none");
        });
    })

})