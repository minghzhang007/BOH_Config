$(".add").click(function(){
    var url = "/boh-config/zk/toAdd";
    window.location.href=url;
});
$(".delete").click(function () {
    var identity = $(this).parent().parent().children("td").eq(0).text();
    var url = "/boh-config/zk/delete?identity="+identity;
    window.location.href =url;
});
$(".update").click(function(){
    var identity = $(this).parent().parent().children("td").eq(0).text();
    var url ="/boh-config/zk/toUpdate?identity="+identity
    layer.open({
        type:2,
        shade: [0.5, '#000', false],
        fix: false, //不固定
        maxmin: true,
        title: ['添加或修改用户类型', false],
        area: ['700px', '500px'],
        content:url
    })
})
$("tr").live({
    mouseover:function(){
        $(this).css("background-color","#eeeeee");
    },
    mouseout:function(){
        $(this).css("background-color","#ffffff");
    }
})