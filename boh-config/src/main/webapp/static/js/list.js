$("#add").click(function(){
    var url = "/boh-config/zk/toAdd";
    window.location.href=url;
});
$("#delete").click(function () {
    var parent = $(this).parent();
    var children = parent.children("td");
    var url = "/boh-config/zk/delete";
    window.location.href =url;
});
$("tr").live({
    mouseover:function(){
        $(this).css("background-color","#eeeeee");
    },
    mouseout:function(){
        $(this).css("background-color","#ffffff");
    }
})