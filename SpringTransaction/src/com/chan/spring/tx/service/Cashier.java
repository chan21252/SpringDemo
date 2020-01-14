package com.chan.spring.tx.service;

import java.util.List;

/**
 * 收银服务接口
 *
 * @author Chan
 */
public interface Cashier {

    /**
     * 结账方法
     */
    public void checkOut(String username, List<String> isbns);
}
