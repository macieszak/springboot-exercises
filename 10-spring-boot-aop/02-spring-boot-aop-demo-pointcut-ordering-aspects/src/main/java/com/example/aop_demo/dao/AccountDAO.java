package com.example.aop_demo.dao;

import com.example.aop_demo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts(boolean tripWire);

    List<Account> findAccounts();

    void addAccount(Account account, boolean vipFlag);

    void addSillyAccount();

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
