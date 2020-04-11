
$(function () {

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
   $.post("/chao/user/getGoodsInfo",function (data,status) {

      var goodsData=JSON.parse(data);


      for(var i=0;i<goodsData.length;i++){

         var str =
   `<div class="outsideDiv" id="div${i}">
        <div class="title">${goodsData[i].goodsInfo.title}</div>
        <div class="mainContent">
            <div class="imgDiv">
                <div class="img"><img class="img-rounded" ></div>
                <div class="img"><img class="img-rounded" ></div>
                <div class="img"><img class="img-rounded" ></div>
                <div class="img"><img class="img-rounded" ></div>
            </div>
            <div class="detailDiv">
                <div class="description" >${goodsData[i].goodsInfo.description}</div>
                <div style="margin-top:10px"><label style="color:black ">价格:</label><div name="price">${goodsData[i].goodsInfo.price}</div></div>
            </div>
        </div>
        <div class="optionDiv">
            <label name="goods_id" style="display: none">${goodsData[i].goodsInfo.goodsId}</label>
            <button name="edit" class="btn btn-info">编辑</button>
            <button name="delete" class="btn btn-info">删除</button>
        </div>
    </div>`;

         $(".content").append(str);
         for(var j=0;j<goodsData[i].pictureAddress.length;j++){


            $(`#div${i} img`).eq(j).attr("src",goodsData[i].pictureAddress[j]);
         }
      }
   });

   $(".content").on("click","button[name=delete]",function () {
      var goodsId=$(this).parent().children("label").text();
      var parent=$(this).parents(".outsideDiv");

      $.post("/chao/user/deleteGoods",{goodsId:goodsId},function (data, status) {
         if(data=="success"){
            parent.remove();
            alert("删除成功");
         }
         else
            alert("删除失败");
      })
   })
   $(".content").on("click","button[name=edit]",function () {


      var goodsId=$(this).parent().children("label").text();
      var parent=$(this).parents(".outsideDiv");


      var title=parent.find(".title").text();
      console.log(title);
      var description=parent.find(".description").text();
      console.log(description);
      let price=parent.find("div[name=price]").text();
      console.log(price);

      $(".content").toggle("normal");
      $(".panel").toggle("normal");

      $(".panel").find("input[id=title]").val(title);
      $(".panel").find("textarea[id=description]").val(description);
      $(".panel").find("input[id=price]").val(price);
      $(".panel").find("input[name=goodsId]").val(goodsId);

   });

   $("#upLoad").click(function () {

      $("form").ajaxSubmit({
         beforeSubmit:function(){
            //检验表单数据是否填写完整
            if($("form input").val()==""||$("textarea").val()==""){
               alert("信息未填写完整");
               return false;
            }
         },
         success: function(data) {
            //成功
            window.location.reload();
            alert(data);
         },
         error:function (err) {
            $(".content").toggle("normal");
            $(".panel").toggle("normal");
            alert("发布遇到错误");
         }
      })
   })
   $("#cancel").click(function () {
      $(".content").toggle("normal");
      $(".panel").toggle("normal");
   })
})