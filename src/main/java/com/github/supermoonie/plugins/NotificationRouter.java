package com.github.supermoonie.plugins;

import com.alibaba.fastjson.JSON;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author supermoonie
 * @since 2021/8/6
 */
public class NotificationRouter {

    private static final String NOTIFICATION_ONCE_CREATE = "notification:once:create:";

    private static final Map<String, TrayIcon.MessageType> MESSAGE_TYPE_MAP = new HashMap<>() {{
        put("info", TrayIcon.MessageType.INFO);
        put("warning", TrayIcon.MessageType.WARNING);
        put("error", TrayIcon.MessageType.ERROR);
        put(null, TrayIcon.MessageType.NONE);
    }};

    public String onQuery(String request) {
        if (request.startsWith(NOTIFICATION_ONCE_CREATE)) {
            String req = request.substring(NOTIFICATION_ONCE_CREATE.length());
            OnceNotificationCreateReq createReq = JSON.parseObject(req, OnceNotificationCreateReq.class);
            TrayIcon.MessageType type = MESSAGE_TYPE_MAP.get(createReq.getType());
            SystemTray.getSystemTray().getTrayIcons()[0].displayMessage(createReq.getTitle(), createReq.getContent(), type);
        }
        return null;
    }
}
