package com.Actitime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class TaskTest extends BaseClass{
	
	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasklink().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnew().click();
		tp.getNewcust().click();
		
		FileLibrary f=new FileLibrary();
		String name = f.ReadDataFromExcelFile("Sheet1", 4, 1);
		tp.getCustname().sendKeys(name);
		
		String desc = f.ReadDataFromExcelFile("Sheet1", 4, 2);
		tp.getCustdesc().sendKeys(desc);
		tp.getCreatecust().click();
		
	}

}
