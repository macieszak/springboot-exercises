package com.example.aop_demo.dao;

import com.example.aop_demo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    void addSillyAccount();

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
