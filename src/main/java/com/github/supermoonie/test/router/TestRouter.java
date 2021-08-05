package com.github.supermoonie.test.router;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 * @author super_w
 * @since 2021/8/4
 */
public class TestRouter {

    public String testQuery() {
        return JOptionPane.showInputDialog(StringUtils.join(new String[]{"hello", "world"}, "/"));
    }
}
