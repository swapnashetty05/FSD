package stepdefs;


import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BrowsingAround {

	String petClinicURL="http://localhost:8080/petclinic";
	
	 WebDriver driver = null; 
		
	   @Given("^I have opened the browser$") 
	   public void openBrowser() { 
	   System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//SeleniumWebDrivers//chromedriver.exe");					
	   driver= new ChromeDriver();		   
	       driver.manage().window().maximize();	

	   } 		
	   
		@And("^I am on the home page$")
		public void i_am_on_the_home_page() throws Throwable {
		
		      driver.navigate().to(petClinicURL); 
		}
		
		/*@When("^When I am on the home page$")
		public void when_i_am_on_the_home_page() throws Throwable {
		
		      driver.navigate().to(petClinicURL); 
		      assertTrue(driver.getCurrentUrl().equals(petClinicURL));
		}*/
		
		@When("^I open veterinarians page$")
		public void I_open_veterinarians_page() {
			driver.get(petClinicURL + "/vets.html");
			assertTrue(driver.getCurrentUrl().equals(petClinicURL + "/vets.html"));
		}

		@Then("^I search for text \"([^\"]*)\"$")
		public void I_search_for_text(String elementName) {
			assertTrue(driver.findElement(By.xpath("/html/body/div/h2")).getText().equalsIgnoreCase(elementName));
		}

		@When("^I search owner \"([^\"]*)\"$")
		public void I_search_owner(String ownerName) {
			driver.get(petClinicURL + "/owners/find.html");
			assertTrue(driver.getCurrentUrl().equals(petClinicURL + "/owners/find.html"));
			WebElement search = driver.findElement(By.xpath("//*[@name='lastName']"));
			System.out.println("Element is :" + search.getText());
			search.sendKeys(ownerName);
			driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/fieldset/div[2]/button")).click();
		}

		@Then("^I get owner \"([^\"]*)\" Informations$")
		public void I_get_owner_Informations(String arg1) {
			String ownersName = driver.findElement(By.xpath("/html/body/div/table[1]/tbody/tr[1]/td/b")).getText();
			System.out.println("Owners name is: " + ownersName);
			assertTrue(ownersName.contains(arg1));
		}
		
		
		@Then("I should see the menu tabs {string} {string} {string} {string}")
		public void i_should_see_the_menu_tabs(String arg1, String arg2, String arg3, String arg4) {
			String home = driver.findElement(By.xpath("/html/body/div/div[1]/div/ul/li[1]/a")).getText();
			System.out.println("home name is: " + home);
			assertTrue(home.contains(arg1));
			
			String owners = driver.findElement(By.xpath("/html/body/div/div[1]/div/ul/li[2]/a")).getText();
			System.out.println("owners name is: " + owners);
			assertTrue(owners.contains(arg2));
			
			String vet = driver.findElement(By.xpath("/html/body/div/div[1]/div/ul/li[3]/a")).getText();
			System.out.println("vet name is: " + vet);
			assertTrue(vet.contains(arg3));
			
			String error = driver.findElement(By.xpath("/html/body/div/div[1]/div/ul/li[4]/a")).getText();
			System.out.println("error name is: " + error);
			assertTrue(error.contains(arg4));
		
		}

}