package com.angel1107.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.angel1107.account.controller.TokenController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApplicationTests {
	@Autowired
	TokenController TokenController;
	@Test
	public void contextLoads() {
		
	}

}
