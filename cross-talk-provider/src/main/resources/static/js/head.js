$(document).ready(function() {
    $("#main").click(toMain);
    $("#top10").click(toMain);
    $("#cross").click(toMain);
    $("#addcross").click(toAddCross);
    $("#toregist").click(toRegist);
    $("#img").click(toImg);
    $("#tologin").click(toLogin);

    // alert(session.getAttribute("name"));
    // sessiongName=session.getAttribute("name");
    // if(!sessionName==null){
    //     alert(sessionName);
    //     $(".lg").css('display', 'none');
    //     $("#myself").text=sessionName;
    // }
});

function toLogin() {
    window.location.href="/tologin";
}
function toMain() {
    window.location.href="/";
}
function toAddCross() {
    window.location.href="/toaddcross";
}
function toRegist() {

}
function toImg() {

}





/**
 * 显示QQ二维码
 *
 * @returns
 */
function showQQImg() {
    layer.open({
        type: 2,
        title: 'QQ二维码',
        area: ['280px', '380px'],
        content: '/img/QQ.png'
    });
}

/**
 * 显示微信二维码
 *
 * @returns
 */
function showWeChatImg() {
    layer.open({
        type: 2,
        title: '微信二维码',
        area: ['280px', '360px'],
        content: '../static/img/WeChat.png'
    });
}

/**
 * 显示微信公众号二维码
 *
 * @returns
 */
function showGZHImg() {
    layer.open({
        type: 2,
        title: '公众号二维码',
        area: ['260px', '310px'],
        content: '/img/GZH.jpg'
    });
}

/**
 * 显示我的信息
 *
 * @returns
 */
function showMe() {
    layer.open({
        type: 2,
        title: 'who i am ?',
        area: ['201px', '245px'],
        content: '/img/me.jpg'
    });
}

/**
 * 判断是否登录，如果登录，将"登录"、"注册" 替换为 "欢迎：userName
 */
// window.onload=function(){
//     if($("#temp").text() !== ''){
//         $(".lg").css('display','none');
//     }
// }



