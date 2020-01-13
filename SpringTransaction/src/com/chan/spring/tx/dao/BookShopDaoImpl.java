package com.chan.spring.tx.dao;

import com.chan.spring.tx.exception.BookStockException;
import com.chan.spring.tx.exception.UserAccountException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 书店购书操作实现类
 *
 * @author Administrator
 */
@Repository(value = "bookShopDaoImpl")
public class BookShopDaoImpl implements BookShopDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据isbn查询书的价格
     *
     * @param isbn isbn号
     * @return BigDecimal价格
     */
    @Override
    public BigDecimal findPriceByBookIsbn(String isbn) {
        String sql = "SELECT price FROM book WHERE isbn = ?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, isbn);
    }

    /**
     * 更新书的库存
     *
     * @param isbn isbn号
     */
    @Override
    public void updateBookStock(String isbn) {
        String sql = "SELECT stock FROM book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        if (stock == 0) {
            throw new BookStockException("书籍库存不足");
        }

        String sql2 = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
        jdbcTemplate.update(sql2, isbn);
    }

    /**
     * 更新用户账户余额
     *
     * @param username 用户名
     */
    @Override
    public void updateUserAccount(String username, BigDecimal price) {
        String sql = "SELECT balance FROM account WHERE username = ?";
        BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, username);
        if (balance.compareTo(price) < 0) {
            throw new UserAccountException("账户余额不足");
        }

        String sql2 = "UPDATE account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql2, price, username);
    }
}
