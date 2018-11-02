$(function () {
    pageto(1);
})
var pageNo = $("#shouye").val();
$(function () {
    $("#shouye").click(pageto);
    $("#pre").click(pageto);
    $("#next").click(function () {
        pageto(this.pageNo+1);
    });
    $("#weiye").click(pageto);


});
function next(pageNo) {
    this.pageNo += 1;
}
function pre(pageNo){
    this.pageNo -=1;
}
function pageto(pageNo) {

    var content = window.document.getElementById("content");
    var str = "";
    // var pageNo=$("#shouye").val();
    $.ajax({
        url: "/cross/listofpage",
        type: "get",
        data: {"pageNo": pageNo},
        dataType: "json",
        success: function (result) {
            if (result.status == 0) {
                var data = result.data;
                for(i in data){
                    str += "<div class='layui-card-body' style='margin: 1%'>" +
                        data[i].content +
                        data[i].greatNumber +
                        "</div>";
                }
                content.innerHTML = str;
            }
        }
    })
}