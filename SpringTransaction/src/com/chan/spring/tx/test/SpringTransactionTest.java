package com.chan.spring.tx.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.chan.spring.tx.dao.BookShopDao;
import com.chan.spring.tx.service.BookShopService;
import com.chan.spring.tx.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring事务测试类
 *
 * @author Administrator
 */
public class SpringTransactionTest {
    private ApplicationContext ctx;
    private JdbcTemplate jdbcTemplate;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    public SpringTransactionTest() {
        ctx = new ClassPathXmlApplicationContext("com/chan/spring/tx/conf/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        bookShopDao = (BookShopDao) ctx.getBean("bookShopDaoImpl");
        bookShopService = (BookShopService) ctx.getBean("bookShopServiceImpl");
        cashier = ctx.getBean(Cashier.class);
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

    /**
     * 测试购书服务
     */
    @Test
    public void testBookShopService() {
        bookShopService.purchase("tom", "978-7-302-46513-3");
    }

    /**
     * 测试结账
     */
    @Test
    public void testCashier() {
        List<String> isbns = new ArrayList<String>();
        isbns.add("978-7-115-33383-4");
        isbns.add("978-7-115-40309-4");
        isbns.add("978-7-302-46513-3");
        cashier.checkOut("jack", isbns);
    }
}
