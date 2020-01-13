package com.chan.spring.tx.exception;

/**
 * 书籍库存异常
 *
 * @author Administrator
 */
public class BookStockException extends RuntimeException {
    public BookStockException(String message) {
        super(message);
    }
}
