/**
 * Created by heyanjing on 2017/11/30 14:26.
 */
var websocket;
if ('WebSocket' in window) {
    console.log(CTX);
    websocket = new WebSocket("ws://127.0.0.1:8080" + CTX + "/websocket/66");
    console.log("此浏览器支持websocket");
} else if ('MozWebSocket' in window) {
    alert("此浏览器只支持MozWebSocket");
} else {
    alert("此浏览器只支持SockJS");
}
websocket.onopen = function (evnt) {
    $("#tou").html("链接服务器成功!")
};
websocket.onmessage = function (evnt) {
    $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
};
websocket.onerror = function (evnt) {
};
websocket.onclose = function (evnt) {
    $("#tou").html("与服务器断开了链接!")
}
$('#send').bind('click', function () {
    send();
});
$('#close').bind('click', function () {
    websocket.close();
});
$('#conn').bind('click', function () {
    websocket = new WebSocket("ws://127.0.0.1:8080" + CTX + "/websocket/66");
});

function send() {
    if (websocket != null) {
        var message = document.getElementById('message').value;
        websocket.send(message);
    } else {
        alert('未与服务器链接.');
    }
}

