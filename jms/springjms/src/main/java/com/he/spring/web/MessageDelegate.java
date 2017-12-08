package com.he.spring.web;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by heyanjing on 2017/12/8 10:52.
 */
public interface MessageDelegate {
    void handleMessage(String message);

    void handleMessage(Map message);

    void handleMessage(byte[] message);

    void handleMessage(Serializable message);
}
