package com.chan.spring.tx.exception;

/**
 * 用户账户异常类
 *
 * @author Administrator
 */
public class UserAccountException extends RuntimeException {
    public UserAccountException(String message) {
        super(message);
    }
}
