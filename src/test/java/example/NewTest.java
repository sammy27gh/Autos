package example;        
 
     
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;       
import org.openqa.selenium.firefox.FirefoxDriver;       
import org.testng.Assert;       
import org.testng.annotations.Test; 
import org.testng.annotations.BeforeTest;   
import org.testng.annotations.AfterTest;        
public class NewTest {      
	
        private WebDriver driver;       
        /* first Test and Second Test will be used for Selenium  Test*/
       
        /*
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
            String expected = "Job Search | one search. all jobs. Indeed.com";
            String actual = driver.getTitle();   
            System.out.println("the check for equals has  ");
            Assert.assertEquals(actual, expected);
        } 
  
        */
        
        // This is the Excel method of parameterisation
       /* public void Email() throws IOException {   
            //connect to excel sheet
             File excel = new File("C:\\Users\\emaildoc\\TestData1.xlsx");
             FileInputStream fis = new FileInputStream(excel);

                          XSSFWorkbook wb = new XSSFWorkbook(fis);
                          XSSFSheet ws = wb.getSheet("Sheet1");

                          
                          int rowNum = ws.getLastRowNum() + 1;
                          int colNum = ws.getRow(0).getLastCellNum();
                          String[][] data = new String[(rowNum - 1)][colNum];

             for (int i=0; i <= ws.getLastRowNum(); i++){
    
             String keyword = ws.getRow(i).getCell(1).getStringCellValue();
             
            System.out.println(keyword);
          */ 
           
           // This is the database method 
        @Test
        	 public void DbEmail() throws ClassNotFoundException, SQLException {
        	      	{
        	    String userName = "sa";
        	    String password = "Sk@456321";
        	     

        	    String url = "jdbc:sqlserver://104.37.189.218\\SQLEXPRESS;databaseName=Books";

        	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	     Connection conn = DriverManager.getConnection(url, userName, password);
        	     Statement sta =  conn.createStatement();
        	     String Sql = "select * from  Autos.[dbo].[USED VEHICLES  CAR DEALER APPROVED  WESTERN PA (1)]";
        	     ResultSet rs = sta.executeQuery(Sql);
        	     while (rs.next()) {
        	   
        	    	 System.out.println(rs.getString(1));
        	   
        	    final String fromEmail = "repairs@mobileautomechanic.info"; //requires valid gmail id
               final String pwd = "Sk@456321"; // correct password for gmail id
              
    		// final String toEmail = (keyword); // thats to excel sheet email
               //final String toEmail = (rs.getString(1));// thats to database Email
               final String toEmail = (rs.getString(1));
               System.out.println("TLSEmail Start");
               Properties props = new Properties();
               props.put("mail.smtp.host", "smtp.ipage.com"); //SMTP Host
               props.put("mail.smtp.port", "587"); //TLS Port
               props.put("mail.smtp.auth", "true"); //enable authentication
               props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
               String subject = "Congratulation on being on our list  ";
               String body = " <h3 >Dear  Member ,<br><br>"
               		+ "I am the repair manager from Mobileautomechanic.info. Concerning your request for our input to help you <br>"
               		+ "buy cars from ebay that will make you profit for your small business, we decided to look at this car we found on ebay.<br>"
               		+ "This car is really great for the price on the bid right now. You can make more than  $2500 this week by just buying this car and reselling it.<br>"
               		+"<br>"
               		+ "So here is the link to the car on ebay ...</h3><br><br> "
               		+ "<h1><a href=\"http://www.ebay.com/itm/351707996914?rmvSB=true"
               		
               		+ "\">2008 Honda </a><h1> "
               		+ "<br><br><br>"
               		+ "<h3>Thank You <br>"
               		+ "Samuel Andoh<br>"
               		+ "Repair  Manager <br>"

               		+ "</h3>";// Email body goes Here 
                
               
               
               
               
               
               
               Authenticator auth;
               
               auth = new Authenticator() {
                   //override the getPasswordAuthentication method
                   @Override
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(fromEmail, pwd);
                   }
               };
               Session session = Session.getInstance(props, auth);
                
               EmailUtil.sendAttachmentEmail(session, toEmail, subject, body);
                
        	      		}
        	      	}
        			}
          
               
   
      /*
		@BeforeTest
        public void beforeTest() {  
            driver = new FirefoxDriver();  
        }       
        @AfterTest
        public void afterTest() {
            driver.quit();          
        }  
        */
}   
