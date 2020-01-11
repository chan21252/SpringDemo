package com.chan.spring.bean.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository("userRepositoryImp")
public class UserRepositoryImp implements UserRepository {
    @Override
    public void save() {
        System.out.println("已保存用户信息");
    }
}
