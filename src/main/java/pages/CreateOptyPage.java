package pages;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateOptyPage extends LoginPage {
	public CreateOptyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='Opportunities Tab']")
	WebElement optyTab;
	
	@FindBy(id="fcf")
	public WebElement optyDropdown;
	
	public boolean verifyOptyPage(WebDriver driver,String title) {
		boolean verifiedOptyTab=false;
		optyTab.click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains(title))
		{
			verifiedOptyTab=true;
		}
		return verifiedOptyTab;
		
	}
	public boolean verifyOptyDropdown(WebDriver driver) {
		boolean verifiedOptyDropdown=false;
		Select oppSelect=new Select(optyDropdown);
		ArrayList<WebElement> oppArray=new ArrayList<>(oppSelect.getOptions());
		String optText[]=new String[10];
		int i=0;
		/*ArrayList<String> expectedOptDropdown=new ArrayList<>
		(Arrays.asList("All Opportunities","Closing Next Month","Closing This Month",
				"My Opportunities","New Last Week","New This Week",
				"Opportunity Pipeline","Private","Recently Viewed Opportunities","Won" ));
		*/
		String[] expectedOptDropdown= {"All Opportunities","Closing Next Month","Closing This Month",
				"My Opportunities","New Last Week","New This Week",
				"Opportunity Pipeline","Private","Recently Viewed Opportunities","Won" };
		for(WebElement opt:oppArray ) {
			optText[i]=opt.getText();
			if(optText[i].equals(expectedOptDropdown[i]))
				verifiedOptyDropdown=true;	
			//System.out.println(optText[i]);
			i++;
		}
		
		//System.out.println(oppText.toString());
		return verifiedOptyDropdown;

	}

}
