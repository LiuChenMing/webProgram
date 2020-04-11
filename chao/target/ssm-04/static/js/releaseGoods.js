$(function () {
    var images=[];
    var maxSize=41504; //4M
    $("#imageInput").change(function () {
        $("#prompt").text("");
        var imgs=this.files;
        if(imgs.length>4){
            $("#prompt").append("<span class=\"glyphicon glyphicon-remove\" style=\"color: red;\"></span>"+"选择的图片数量超过了4张，请重新选择！");
            $("#imageInput").val("");
            return;
        }
        else{
            for(var i=0;i<imgs.length;i++){
                //限制图片大小不得超过4M
                if(imgs[i].size>4194304){
                    $("#prompt").append("<span class=\"glyphicon glyphicon-remove\" style=\"color: red;\"></span>"+"每张图片大小不得大于4M")
                    $("#imageInput").val("");
                    return;
                }
            }

            $("#prompt").append("已选择了"+imgs.length+"张图片");
        }

    })

    $("#upLoad").click(function () {

        $("form").ajaxSubmit({
            beforeSubmit:function(){
                //检验表单数据是否填写完整
                if($("form input").val()==""||$("textarea").val()==""){
                    alert("信息未填写完整")
                    return false;
                }
            },
            uploadProgress: function(event, position, total, percentComplete) {//上传的过程
                //position 已上传了多少
                //total 总大小
                //已上传的百分数
                var percentVal = percentComplete + '%';
                $(".progress-bar").css("width",percentVal);
                $(".progress-bar").text(percentVal);
                console.log(percentVal, position, total);
            },
            success: function(data) {
                //成功
                var percentVal = '100%';
                $(".progress-bar").css("width",percentVal);
                $(".progress-bar").text(percentVal);
                alert(data);
            },
            error:function (err) {
                alert("发布遇到错误");
            }
        })
    })
})