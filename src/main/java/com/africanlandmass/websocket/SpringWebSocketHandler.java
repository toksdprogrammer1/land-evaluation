package com.africanlandmass.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringWebSocketHandler extends TextWebSocketHandler {

    private static Logger logger = LoggerFactory.getLogger(SpringWebSocketHandler.class);

    private static final List<WebSocketSession> users;

    static {
        users = new ArrayList<>();
    }

    public SpringWebSocketHandler() {
    }

    public void afterConnectionEstablished(WebSocketSession session) {
        logger.debug("open websocket connection!");
        users.add(session);
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        logger.debug("close websocket connection");
        users.remove(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
    }

    public void sendMessage(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        logger.debug("transportation error, ，close websocket connection... ");
        users.remove(session);
    }

    public boolean supportsPartialMessages() {
        return false;
    }
}
