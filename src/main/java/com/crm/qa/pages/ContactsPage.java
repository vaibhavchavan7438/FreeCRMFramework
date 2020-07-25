package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testBase.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//table[@class='datacard']/tbody/tr[4]/td[1]")
	WebElement checkbox1;

	@FindBy(xpath="//table[@class='datacard']/tbody/tr[5]/td[1]")
	WebElement checkbox2;
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
//	public void selectContactsByName(String name){
//		////td[@class='datalistrow']//*[@type='checkbox' and @value='52742821']
//		
//		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
//				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
//	}
	

	public boolean selectContactsCheckbox() throws InterruptedException{
		checkbox1.click();
		Thread.sleep(2000);
		Boolean isSelected=checkbox1.isSelected();
		return isSelected;
		
	}
	
	
	public boolean selectMultipleContactsCheckbox() throws InterruptedException{
		
		checkbox1.click();
		
		checkbox2.click();
		
		Boolean isSelected1=checkbox1.isSelected();

		Boolean isSelected2=checkbox2.isSelected();
		
		if(isSelected1==true&&isSelected2==true) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

	
	public void createNewContact(String title, String ftName, String ltName, String comp) throws InterruptedException{
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	
	

}
