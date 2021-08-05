package com.github.supermoonie.plugins;

import lombok.Data;

/**
 * @author supermoonie
 * @since 2021/7/25
 */
@Data
public class OnceNotificationCreateReq {

    private String title;

    private String content;

    private String type;
}
