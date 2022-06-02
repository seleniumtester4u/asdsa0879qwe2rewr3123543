package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	private static WebDriver driver;
	//HomePage hp = new HomePage(driver);
	//Locators
	private By Username = By.xpath("//input[@aria-label='Email or phone']");
	private By Password = By.xpath("//input[@aria-label='Enter your password']");
	private By JewelryandWatches_checkbox = By.xpath("//div[@aria-label='Jewelry and Watches']");
	private By FoodandGrocery_checkbox = By.xpath("//div[@aria-label='Food and Grocery']");
	private By ElectronicsandComputers_checkbox = By.xpath("//div[@aria-label='Electronics and Computers']");
	private By color_editbox = By.xpath("//span[text()='Which color would you like?']/ancestor::div[@role='listitem']//input");
	private By yes_checkbox = By.xpath("//div[@data-value='Yes']");
	private By no_checkbox = By.xpath("//div[@data-value='No']");
	private By name_editbox = By.xpath("//span[text()='Name']/ancestor::div[@role='listitem']//input");
	private By fileupload = By.xpath("//span[text()='Add File']");
	private By iframe = By.xpath("(//iframe[@allow=\"camera\"])[last()]");
	private By selectfile = By.xpath("//div[text()='Select files from your device']");
	private By selectfilefromdisk = By.xpath("//input[@type='file']");
	private By mydrive = By.xpath("(//div[@role='tab']//div)[2]");			
	private By file_upload_button = By.xpath("(//*[@id='picker:ap:0'])[last()]");
	private By dateeditbox = By.xpath("//input[@type='date']");
	private By email_Notification_radiobtn = By.xpath("//div[@data-value='Email']");
	private By email_editbox = By.xpath("//input[@type='email']");		
	private By phone_editbox = By.xpath("//input[@aria-labelledby='i1']");
	private By nextbutton = By.xpath("//span[text()='Next']");
	private By submitbutton = By.xpath("//span[text()='Submit']");		
	private By No_radiobutton = By.xpath("//span[text()='No']");


	//constructor
	public HomePage (WebDriver driver){
		this.driver = driver;
	}

	public void launchURL(String url){
		driver.get(url);
	}

	public String getHomePageTitle(){

		return driver.getTitle();
	}

	public static boolean verifyWebElement(By wd) {
		if(driver.findElement(wd).getSize().getHeight() > 0) {
			return true;
		}
		return false;
	}
	public boolean EnterUsername(String Uname){
		try{
			verifyWebElement(Username);
			driver.findElement(Username).sendKeys(Uname);
			driver.findElement(Username).sendKeys(Keys.ENTER);

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean EnterPassword(String Pwd){
		try{
			verifyWebElement(Password);
			driver.findElement(Password).sendKeys(Pwd);
			driver.findElement(Password).sendKeys(Keys.ENTER);

			return true;
		}catch(Exception e){

			return false;
		}

	}

	public boolean clicksignin(){
		try{
			verifyWebElement(Password);
			driver.findElement(Password).sendKeys(Keys.ENTER);

			return true;
		}catch(Exception e){

			return false;
		}

	}

	public boolean selectcheckbox(){
		try{

			verifyWebElement(ElectronicsandComputers_checkbox);
			verifyWebElement(JewelryandWatches_checkbox);
			verifyWebElement(FoodandGrocery_checkbox);

			if(driver.findElement(ElectronicsandComputers_checkbox).getAttribute("aria-checked").equals("false"))
			{
				driver.findElement(ElectronicsandComputers_checkbox).click();
			}
			if(driver.findElement(FoodandGrocery_checkbox).getAttribute("aria-checked").equals("false"))
			{
				driver.findElement(FoodandGrocery_checkbox).click();
			}
			if(driver.findElement(JewelryandWatches_checkbox).getAttribute("aria-checked").equals("false"))
			{
				driver.findElement(JewelryandWatches_checkbox).click();
			}
			return true;
		}catch(Exception e){

			return false;
		}

	}


	public boolean colorEditbox(String color){
		try{
			verifyWebElement(color_editbox);
			driver.findElement(color_editbox).clear();

			driver.findElement(color_editbox).sendKeys(color);

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean yes_checkbox(String val){
		try{
			verifyWebElement(yes_checkbox);
			driver.findElement(yes_checkbox).click();

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean nameEditbox(String name){
		try{
			verifyWebElement(name_editbox);
			driver.findElement(name_editbox).clear();

			driver.findElement(name_editbox).sendKeys(name);

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public static void jclick(By ws) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.display = 'block';", driver.findElement(ws));

		js.executeScript("arguments[0].click();", driver.findElement(ws));
	}

	public void fileUpload(){
		jclick(fileupload);
		//driver.findElement(fileupload).click();
		driver.switchTo().frame(driver.findElement(iframe));

		WebDriverWait wait = new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.presenceOfElementLocated(selectfile));
		jclick(selectfile);
		driver.findElement(selectfile).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Robot rb;
		try {
			rb = new Robot();
			StringSelection str = new StringSelection(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\Sample.txt");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			//rb.mouseMove(x, y);


		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RemoteWebElement file_upload = ((RemoteWebElement) driver.findElement(file_upload_button));
		((HasInputDevices) driver).getMouse().mouseMove(file_upload.getCoordinates());

		driver.findElement(file_upload_button).sendKeys(Keys.ENTER);
		jclick(file_upload_button);
		// copying File path to Clipboard.
		driver.switchTo().parentFrame();

	}

	public boolean dateEditbox(){
		try{			
			driver.findElement(dateeditbox).sendKeys("01-01-2022");

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean Notificationradio(){
		try{
			verifyWebElement(email_Notification_radiobtn);
			//driver.findElement(email_Notification_radiobtn).click();
			jclick(email_Notification_radiobtn);
			//driver.findElement(dateeditbox).sendKeys(Keys.ENTER);

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean emailforUpdates(String name){
		try{
			verifyWebElement(email_editbox);
			driver.findElement(email_editbox).clear();

			driver.findElement(email_editbox).sendKeys(name);

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean phoneforUpdates(String name){
		try{
			verifyWebElement(phone_editbox);
			driver.findElement(phone_editbox).clear();

			driver.findElement(phone_editbox).sendKeys(name);

			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean next_Button(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			verifyWebElement(nextbutton);
			jclick(nextbutton);
			//	driver.findElement(nextbutton).click();			
			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean Noradiobutton(){
		try{
			verifyWebElement(No_radiobutton);
			jclick(No_radiobutton);
			//	driver.findElement(nextbutton).click();			
			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean submit_button(){
		try{
			verifyWebElement(submitbutton);
			jclick(submitbutton);
			//	driver.findElement(nextbutton).click();			
			return true;
		}catch(Exception e){

			return false;
		}
	}
}