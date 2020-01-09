package com.chan.spring.bean.generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务层基类
 *
 * @param <T>
 */
public class BaseService<T> {
    /**
     * 依赖BaseRepository，Autowired注解供子类继承
     */
    @Autowired
    protected BaseRepository<T> repository;

    public void add() {
        System.out.println("add...");
        System.out.println(repository);
    }
}
