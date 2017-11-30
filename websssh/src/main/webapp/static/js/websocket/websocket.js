/**
 * Created by heyanjing on 2017/11/30 14:26.
 */
console.log(11111);
// a.「var socket = new SockJS(‘/SpringWebsocket/websocket’);」初始化一个SockJs对象，其中SpringWebsocket是自己的工程名，websocket是在Servlet-context.xml中配置的websocket的endpoint
// b.「stompClient.send("/app/hello", {}, JSON.stringify({'name': $(“#name”).val()}));」发送消息到websocket，对应的方法是controller中的@MessageMapping(“/hello”)注解方法，注意多了个app前缀，是在Servlet-context.xml中配置的application-destination-prefix
// c.「stompClient.subscribe(‘/topic/greetings’, function (greeting) {
//     showGreeting(JSON.parse(greeting.body).content);
// });」表示从broker中订阅/topic/greetings,当有消息发送到/topic/greetings时，客户端就可以收到通知，并获取消息的内容。

//region Description

var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS(CTX+'/init');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            console.log(greeting);
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    console.log(222);
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
    console.log('222x');
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
//endregion