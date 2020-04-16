package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class TEDsearchpage extends PageBase {

	public TEDsearchpage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}

	WebDriver driver1;
	

	//click apps button
	@FindBy(xpath = "/html/body/div[1]/div[1]/c-wiz[1]/ul/li[2]/a")
	WebElement Appsbutton;
	
	//categories
	@FindBy(xpath="/html/body/div[1]/div[1]/c-wiz[2]/c-wiz/div/div/div/div[1]/div/div[1]")
	WebElement Categories;
	
	//select Education
	@FindBy(xpath="/html/body/div[1]/div[1]/c-wiz[2]/c-wiz/div/div/div/div[1]/div/div[2]/div/ul/li[3]/ul/li[9]")
	WebElement Education;
	
	
	@FindBy(xpath="/html/body/div[1]/c-wiz[1]/div/div[1]/div[1]/div[3]/div/div/div/form/fieldset[2]/div/div/div[2]/input")
	WebElement searchbox;
	
	@FindBy(id="gbqfbw")
	WebElement searchbutton;
	
	@FindBy(xpath = "/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/c-wiz/c-wiz/c-wiz/div/div[2]/div[1]/c-wiz/div/div/div[1]/div/div")
	WebElement TEDicon;
	
	@FindBy(xpath = "/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/c-wiz/c-wiz/c-wiz/div/div[2]/div[1]/c-wiz/div/div/div[1]/div/div")
	WebElement FBicon;
	
	@FindBy(xpath="/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[1]/div/img")
	WebElement FBImage;
	
	
	public void SelectApps()
	{
		
		Appsbutton.click();
		waitMethod(3000);
		
		//assert that we in the apps page
		String appsurl = driver1.getCurrentUrl();
		Assert.assertEquals(appsurl, "https://play.google.com/store/apps" );
		System.out.println("Apps page is the correct page");

	}
	
	public void SelectEducation() {
		
		Categories.click();
		Education.click();
		waitMethod(3000);
		
		//assert that we in the education page
		String educationbutton = driver1.findElement(By.id("action-dropdown-parent-Education")).getText();
		String ExpectedTitle = "Education";
		Assert.assertEquals(educationbutton, ExpectedTitle);
		System.out.println("We're in Education Page");

	}

	public void TedSearch() {
		
		searchbox.sendKeys("TED");
		searchbutton.click();
		waitMethod(3000);
		TEDicon.click();
		waitMethod(3000);
		
		//assert that we in the TED app page
		String installbutton = driver1.findElement(By.xpath("/html/body/div[1]/div[4]/c-wiz[3]/div/div[2]/div/div[1]/div/c-wiz[1]/c-wiz[1]/div/div[2]/div/div[2]/div/div[2]/div/c-wiz/c-wiz/div/span/button")).getText();
		String ExpectedTitle = "Install";
		Assert.assertEquals(installbutton, ExpectedTitle);
		System.out.println("TED app Install");
	}
	
	public void FBsearch() {
		searchbox.sendKeys("facebook");
		searchbutton.click();
		waitMethod(3000);
		FBicon.click();
		waitMethod(3000);
        
		//assert that facebook icon is exist
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver1).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", FBImage);
        if (!ImagePresent)
        {
             System.out.println("icon not exists.");
        }
        else
        {
            System.out.println("icon exists.");
        }
	}
	
	
}
	
