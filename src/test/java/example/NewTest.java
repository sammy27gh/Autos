package example;        
 
     
import org.openqa.selenium.WebDriver;       
import org.openqa.selenium.firefox.FirefoxDriver;       
import org.testng.Assert;       
import org.testng.annotations.Test; 
import org.testng.annotations.BeforeTest;   
import org.testng.annotations.AfterTest;        
public class NewTest {      
	
        private WebDriver driver;       
        
        @Test
        public void firstTest() {    
        	System.out.println("This is the first test ");
            driver.get("http://www.guru99.com/selenium-tutorial.html");  
            String title = driver.getTitle();   
            System.out.println("Test if the title containf free selenium tutorial ");
            Assert.assertTrue(title.contains("Free Selenium Tutorials"));       
        } 
        @Test
        public void secondTest() {    
        	System.out.println("This is the second test ");
            driver.get("http://www.indeed.com/");  
            String title = driver.getTitle();   
            System.out.println("seee if second test worked ");
            Assert.assertTrue(title.contains("second"));       
        } 
        public void ThirdTest() {    
        	System.out.println("This is the third Test ");
            driver.get("http://www.indeed.com/");  
            String title = driver.getTitle();   
            System.out.println("seee if third test worked ");
            Assert.assertTrue(title.contains("indeed"));       
        }
        @BeforeTest
        public void beforeTest() {  
            driver = new FirefoxDriver();  
        }       
        @AfterTest
        public void afterTest() {
            driver.quit();          
        }       
}   
