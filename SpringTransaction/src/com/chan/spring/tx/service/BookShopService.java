package com.chan.spring.tx.service;

/**
 * 书店服务接口
 */
public interface BookShopService {
    /**
     * 买书
     *
     * @param username 用户名
     * @param isbn     isbn号
     */
    public void purchase(String username, String isbn);
}
