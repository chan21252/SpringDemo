package com.chan.spring.tx.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.chan.spring.tx.dao.BookShopDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

/**
 * Spring事务测试类
 *
 * @author Administrator
 */
public class SpringTransactionTest {
    private ApplicationContext ctx;
    private JdbcTemplate jdbcTemplate;
    private BookShopDao bookShopDao;

    public SpringTransactionTest() {
        ctx = new ClassPathXmlApplicationContext("com/chan/spring/tx/conf/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        bookShopDao = ctx.getBean(BookShopDao.class);
    }

    /**
     * 测试数据源
     */
    @Test
    public void testDataSource() {
        DruidDataSource ds = (DruidDataSource) ctx.getBean("dataSource");
        System.out.println(ds);
        ds.close();
    }

    /**
     * 测试更新账户余额
     */
    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("tom", new BigDecimal(50));
    }

    /**
     * 测试更新库存
     */
    @Test
    public void testBookShopDaoUpdateBookStock() {
        bookShopDao.updateBookStock("978-7-302-46513-3");
    }

    /**
     * 测试查询价格
     */
    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        BigDecimal price = bookShopDao.findPriceByBookIsbn("978-7-302-46513-3");
        System.out.println(price);
        assert (price.compareTo(new BigDecimal("148.00")) == 0);
    }
}
