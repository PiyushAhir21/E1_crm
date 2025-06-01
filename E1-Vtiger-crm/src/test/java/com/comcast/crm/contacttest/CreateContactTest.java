package com.comcast.crm.contacttest;

import java.io.IOException;

import org.testng.annotations.Test;

import base_utility.BaseClass;

public class CreateContactTest extends BaseClass {

	@Test
	public void createConTest() throws IOException, InterruptedException {

		System.out.println("Created Contact");
		
		Thread.sleep(5000);
	}

}
