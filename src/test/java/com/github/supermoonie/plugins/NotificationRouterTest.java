package com.github.supermoonie.plugins;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author supermoonie
 * @since 2021/8/6
 */
public class NotificationRouterTest {

    @Test
    public void subString() {
        String text = "foo:bar";
        System.out.println(text.substring("foo:".length()));
    }

}