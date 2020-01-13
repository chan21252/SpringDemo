package com.chan.spring.tx.dao;

import java.math.BigDecimal;

/**
 * 书店数据操作接口
 *
 * @author Administrator
 */
public interface BookShopDao {
    /**
     * 根据isbn查询书的价格
     *
     * @param isbn isbn号
     * @return BigDecimal价格
     */
    public BigDecimal findPriceByBookIsbn(String isbn);

    /**
     * 更新书的库存
     *
     * @param isbn isbn号
     */
    public void updateBookStock(String isbn);

    /**
     * 更新用户账户余额
     *
     * @param username 用户名
     */
    public void updateUserAccount(String username, BigDecimal price);
}
