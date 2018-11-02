$(function () {
    $("#login").click(checkLogin);
});
function checkLogin() {
    var userName=$("#userName").val().trim();
    var password=$("#password").val().trim();
    $.ajax({
        url:"/user/login",
        type:"post",
        data:{"userName":userName, "password":password},
        dataType:"json",
        success:function (result) {
            if(result.status==1){
                $("#errorMsg").text(result.msg);
            }else if(result.status==0){
                window.location.href="/";
            }
        }
    })
}