package com.github.supermoonie.plugins;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author supermoonie
 * @since 2021/8/6
 */
@Slf4j
public class NotificationRouter {

    private static final String NOTIFICATION_ONCE_CREATE = "notification:once:create:";

    private static final Map<String, TrayIcon.MessageType> MESSAGE_TYPE_MAP = new HashMap<String, TrayIcon.MessageType>() {{
        put("info", TrayIcon.MessageType.INFO);
        put("warning", TrayIcon.MessageType.WARNING);
        put("error", TrayIcon.MessageType.ERROR);
        put(null, TrayIcon.MessageType.NONE);
    }};

    public String notify(String request) {
        OnceNotificationCreateReq createReq = JSON.parseObject(request, OnceNotificationCreateReq.class);
        TrayIcon.MessageType type = MESSAGE_TYPE_MAP.get(createReq.getType());
        SystemTray.getSystemTray().getTrayIcons()[0].displayMessage(createReq.getTitle(), createReq.getContent(), type);
        return null;
    }
}
