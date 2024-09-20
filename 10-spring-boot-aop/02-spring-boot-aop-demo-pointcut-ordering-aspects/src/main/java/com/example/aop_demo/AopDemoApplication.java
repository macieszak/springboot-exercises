package com.example.aop_demo;

import com.example.aop_demo.dao.AccountDAO;
import com.example.aop_demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runnner -> {
			//demoTheBeforeAdvice(accountDAO, membershipDAO);
			//demoTheAfterReturningAdvice(accountDAO);
			demoTheAfterThrowingAdvice(accountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("\n\nMain program: demoTheAfrterReturningAdvice");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		account.setName("testName");
		account.setLevel("testLevel");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		accountDAO.addSillyAccount();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addAccount();
		membershipDAO.goToSleep();
	}

}
