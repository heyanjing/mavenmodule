package com.he.spring.web.websocket3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * Created by heyanjing on 2017/12/1 10:18.
 */
@Component
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    private static final Logger log = LoggerFactory.getLogger(HandshakeInterceptor.class);
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("Before Handshake");
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        log.info("After Handshake");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
