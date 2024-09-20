package com.example.aop_demo.dao;

import com.example.aop_demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
    }

    @Override
    public void addSillyAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: SILLY ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
