package com.chan.spring.tx.service;

import com.chan.spring.tx.dao.BookShopDao;
import com.chan.spring.tx.exception.BookStockException;
import com.chan.spring.tx.exception.UserAccountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * 书店服务实现类
 *
 * @author Chan
 */
@Service(value = "bookShopServiceImpl")
public class BookShopServiceImpl implements BookShopService {

    @Resource(name = "bookShopDaoImpl")
    private BookShopDao bookShopDao;

    /**
     * 买书
     *
     * @param username 用户名
     * @param isbn     isbn号
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {BookStockException.class, UserAccountException.class},
            noRollbackFor = {IOException.class, SQLException.class},
            readOnly = false,
            timeout = 5
    )
    @Override
    public void purchase(String username, String isbn) {
        //获取书的单价
        BigDecimal price = bookShopDao.findPriceByBookIsbn(isbn);
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
        //更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }
}
