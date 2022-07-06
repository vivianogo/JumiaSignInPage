import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @Test
    public void LaunchUrl() throws InterruptedException {
        //Locate the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Open the browser
        driver = new ChromeDriver();
        //Input the Jumia Url
        driver.get("https://www.jumia.com.ng/");
        Thread.sleep(4000);
        //Test 1: Verify the Url
        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl))
              System.out.println("Current Url is:" + expectedUrl);
            else
              System.out.println("Wrong Url");
        //Maximize the page
        driver.manage().window().maximize();
        Thread.sleep(2000);

        }

    public class testMe {
       @Test(priority = 0)
       public void GetPageTitle() throws InterruptedException {
           //Test 2 Verify page title
           // Get page title
           System.out.println("Page Title is:" + driver.getTitle());
           Thread.sleep(2000);
            }

       @Test(priority = 1)
       public void SignIn() throws InterruptedException {
           //Test 3 Verify that user lands on Login page when user clicks on Sign in button
           // Click on Account
           driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
           Thread.sleep(3000);
           //Click on Sign In
           driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
           Thread.sleep(2000);

           String expectedPageTitle = "Login Page";
           String actualPageTitle = driver.getTitle();
                if (actualPageTitle.contains(expectedPageTitle))
                    System.out.println("Successful:"+"Test Case Passed");
                else
                    System.out.println("Test Case Failed");

            }

       @Test (priority = 2)
       public void InvalidEmail() throws InterruptedException {
           //Test 6 Verify that user cannot sign in with an invalid email
           // Click on Account
           driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
           Thread.sleep(3000);
           //Click on Sign In
           driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
           Thread.sleep(2000);
           //Input an invalid email address
           driver.findElement(By.id("fi-email")).sendKeys("iogochuk.com");
           //Input valid password
           driver.findElement(By.id("fi-password")).sendKeys("admin");
           //Click login
           driver.findElement(By.xpath("//*[@id=\"authForm\"]/button/span")).click();
           Thread.sleep(2000);

           String expectedErrorMsg = "Incorrect E-mail or Password";
           String actualMsg = driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[1]/div[1]/div")).getText();
           System.out.println("Incorrect E-mail or Password");
                if(actualMsg.equals(expectedErrorMsg))
                    System.out.println("Test Case Passed");
                else
                    System.out.println("Test Case Failed");
           Thread.sleep(4000);

            }

       @Test (priority = 3)
       public void InvalidPassword() throws InterruptedException {
                //Test 7 Verify that user cannot sign in with an invalid password
                //Clear email field
                driver.findElement(By.id("fi-email")).clear();
                Thread.sleep(1000);
                // Input valid email address
                driver.findElement(By.id("fi-email")).sendKeys("ogochukwu@mailinator.com");
                //Input an invalid password
                driver.findElement(By.id("fi-password")).sendKeys(".com");
                //Click login
                driver.findElement(By.xpath("//*[@id=\"authForm\"]/button/span")).click();
                Thread.sleep(2000);

                String expectedErrorMsg = "Incorrect E-mail or Password";
                String actualMsg = driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[1]/div[1]/div")).getText();
                System.out.println("Incorrect E-mail or Password");
                if(actualMsg.equals(expectedErrorMsg))
                    System.out.println("Test Case Passed");
                else
                    System.out.println("Test Case Failed");
                Thread.sleep(4000);

            }

            @Test (priority = 4 )
            public void EmptyFields() throws InterruptedException {
                //Test 8 Verify that user cannot sign in leaving email and password fields empty
                //Clear email field
                Thread.sleep(1000);
                driver.findElement(By.id("fi-email")).clear();
                // Leave email address field empty
                driver.findElement(By.id("fi-email")).sendKeys("");
                //leave password field empty
                driver.findElement(By.id("fi-password")).sendKeys("");
                //Click login
                driver.findElement(By.xpath("//*[@id=\"authForm\"]/button/span")).click();

                String expectedErrorMsg = "Required field";
                String actualMsg = driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[1]/div[2]/div")).getText();
                System.out.println("Required field");
                if(actualMsg.equals(expectedErrorMsg))
                    System.out.println("Test Case Passed");
                else
                    System.out.println("Test Case Failed");
                Thread.sleep(4000);

            }

            @Test (priority = 5 )
            public void ShowPassword() throws InterruptedException {
                //Test 9 Verify that user can show password text
                //Clear email field
                driver.findElement(By.id("fi-email")).clear();
                // Leave email address field empty
                driver.findElement(By.id("fi-email")).sendKeys("");
                //Input a password text
                driver.findElement(By.id("fi-password")).sendKeys("admin");
                Thread.sleep(1000);
                //Click on the 'eye' icon
                driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[1]/div[2]/button")).click();
                Thread.sleep(4000);

            }

            @Test (priority = 6)
            public void HidePassword() throws InterruptedException {
                //Test 10 Verify that user can hide password text
                //Click on the 'eye' icon
                driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[1]/div[2]/button")).click();
                Thread.sleep(4000);

            }

            @Test (priority = 7)
            public void RememberMe () throws InterruptedException {
                //Test 11 Verify Remember me box is clickable
                driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[1]/div[3]/div")).click();
                Thread.sleep(3000);
            }
            @Test (priority = 8)
            public void ForgotPassword() throws InterruptedException {
                //Test 12 Verify that forgot password link is clickable
                driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[1]/div[3]/a")).click();
                String expectedPageTitle = "Recover Password";
                String actualPageTitle = driver.getTitle();
                if (actualPageTitle.contains(expectedPageTitle))
                    System.out.println("Page Title is:" + driver.getTitle());
                else
                    System.out.println("Test Case Failed");
                Thread.sleep(4000);
            }
            @Test (priority = 9)
            public void ValidLoginDetail () throws InterruptedException {
                //Test 4 Verify that user can sign in successfully with valid details
                // Click on Account
                driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
                Thread.sleep(3000);
                //Click on Sign In
                driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
                Thread.sleep(2000);
                //Input valid email address
                driver.findElement(By.id("fi-email")).sendKeys("ogochukwu@mailinator.com");
                //Input valid password
                driver.findElement(By.id("fi-password")).sendKeys("admin");
                //Click login
                driver.findElement(By.xpath("//*[@id=\"authForm\"]/button")).click();

                String expectedUserIcon = "Hi, Pere";
                String actualUserIcon = driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).getText();
                if (actualUserIcon.contains(expectedUserIcon))
                    System.out.println("Login is Successful");
                else
                    System.out.println("Test Case Failed");
                Thread.sleep(5000);

            }

            @Test (priority = 10)
            public void LogoutFunctionality() throws InterruptedException {
                //Test 5 Verify that user logout successfully and is taken to homepage
                // Click on user icon
                driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
                Thread.sleep(3000);
                //Click logout
                driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
                Thread.sleep(3000);
                String expectedUrl = "https://www.jumia.com.ng/";
                String actualUrl = driver.getCurrentUrl();
                if (actualUrl.contains(expectedUrl))
                    System.out.println("Logout is Successful");
                else
                    System.out.println("Test case failed");
                Thread.sleep(3000);
            }

            @AfterTest
            public void Quit() {
                //quit the browser
                driver.quit();
            }
        }
}

