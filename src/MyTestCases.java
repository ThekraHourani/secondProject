import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class MyTestCases {
WebDriver driver = new ChromeDriver();
String website	="https://codenboxautomationlab.com/practice/";
Random rand	=new Random();


@BeforeTest 
public void mysetup() {
	driver.manage().window().maximize();
	driver.get(website);
}




@Test(priority = 1,description = "RadioButton",invocationCount = 5,enabled = false)// تكرار التيستinvocationCount = 5ا
public void Radio_Button_Test() {
 List<WebElement> AllRadioButton =driver.findElements(By.className("radioButton"));
//AllRadioButton.get(0).click();//To Click to The First option
  int randomIndex= rand.nextInt(AllRadioButton.size()); //size 3 it will generate 1,2,3
  AllRadioButton.get(randomIndex).click();
}

@Test(priority = 1,description = "Dynamic Dropdown",invocationCount = 1,enabled =false)// تكرار التيستinvocationCount = 5ا
public void Dynamic_Dropdown_Test() throws InterruptedException {
	String[] countryCodes = { "US", "CA", "OM", "BR", "AR", "FR", "DE", "IT", "ES" };
	int randomIndex = rand.nextInt(countryCodes.length);

	WebElement DynamicListInput = driver.findElement(By.id("autocomplete"));
	DynamicListInput.sendKeys(countryCodes[randomIndex]);
	Thread.sleep(1000);
	DynamicListInput.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));

}

@Test(priority = 1,description = "Static Dropdown ",invocationCount = 1,enabled = false)// تكرار التيستinvocationCount = 5ا
public void Static_Dropdown_Test() {
	WebElement SelectElement = driver.findElement(By.id("dropdown-class-example"));
	Select sel = new Select(SelectElement);

	//sel.selectByIndex(3);
	// sel.selectByValue("option2");
	// sel.selectByVisibleText("API");
}

@Test(priority = 1,description = "Checkbox",invocationCount = 1,enabled =false)// تكرار التيستinvocationCount = 5ا
public void Checkbox_Test() throws InterruptedException {
	
	List<WebElement> CheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	int randomIndex = rand.nextInt(CheckBoxes.size());
	//System.out.println(CheckBoxes.size());
	Thread.sleep(1000);
	 CheckBoxes.getFirst().click();
	// CheckBoxes.getLast().click();
	// CheckBoxes.get(96).click();

	// CheckBoxes.get(randomIndex).click();

	// to select them all
	for (int i = 0; i < CheckBoxes.size(); i++) {
		CheckBoxes.get(i).click();
	}
	
	
	
	
	
}

@Test(priority = 5, description = "Alert and confirm",enabled = false)
public void Switch_To_Alert_Example() throws InterruptedException {
	WebElement nameBox = driver.findElement(By.id("name"));
	nameBox.sendKeys("abedalraheem");
//	WebElement AlertBox = driver.findElement(By.id("alertbtn"));
//	AlertBox.click();
	
	Thread.sleep(1000);
	//driver.switchTo().alert().accept();
	//driver.switchTo().alert().dismiss();

	
	WebElement ConfirmBox = driver.findElement(By.id("confirmbtn"));
	ConfirmBox.click();
	Thread.sleep(1000);
	//driver.switchTo().alert().accept();
	//driver.switchTo().alert().dismiss();
	
	//System.out.println(driver.switchTo().alert().getText());


}

@Test (priority = 1,description = "this is to move from window to anther one ",enabled =false)
public void  Switch_Window () throws InterruptedException {

	WebElement OpenWindowButton = driver.findElement(By.id("openwindow"));
	OpenWindowButton.click();
	Thread.sleep(2000);
	List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
	// number of opened windows
	//System.out.println(windowsHandels.size());
//switch to the other window  
	driver.switchTo().window(windowsHandels.get(1));
	// in the second window
	WebElement ContactButton = driver.findElement(By.id("menu-item-9680"));
	ContactButton.click();

	//System.out.println(driver.getTitle() + " hello from the second window");

driver.close();
	// switch to the first window
	driver.switchTo().window(windowsHandels.get(0));

}

@Test(priority = 6, description = "check moving to another tab")

public void Switch_window_Example() throws InterruptedException {
	WebElement OpenTabButton = driver.findElement(By.id("opentab"));

	OpenTabButton.click();

	List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(windowsHandels.get(1));
Thread.sleep(2000);
	System.out.println(driver.getTitle());
}

@Test(priority = 6, description = "check moving to another tab")

public void Switch_Tab_Example() throws InterruptedException {
	WebElement OpenTabButton = driver.findElement(By.id("opentab"));

	OpenTabButton.click();

	List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
	
	driver.switchTo().window(windowsHandels.get(1));
	
Thread.sleep(2000);
	//System.out.println(driver.getTitle());
}

@Test(priority = 8, description = " play with the data of the column " ,enabled = true)

public void Web_Table_Example() {

	WebElement TheTable = driver.findElement(By.id("product"));

	List<WebElement> theDataInsideTheTable = TheTable.findElements(By.tagName("tr"));

	for (int i = 1; i < theDataInsideTheTable.size(); i++) {
		
		int totalTdInTheRow = theDataInsideTheTable.get(i).findElements(By.tagName("td")).size();

		System.out.println(
				theDataInsideTheTable.get(i).findElements(By.tagName("td")).get(totalTdInTheRow - 1).getText());
	}

}







































}

