package com.chan.spring.tx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收银实现类
 *
 * @author Chan
 */
@Service(value = "cashierImpl")
public class CashierImpl implements Cashier {
    @Resource(name = "bookShopServiceImpl")
    private BookShopService bookShopService;

    /**
     * 结账方法
     *
     * @param username 用户名
     * @param isbns    isbn号
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackForClassName = {"Exception"}
    )
    @Override
    public void checkOut(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
