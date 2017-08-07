package co.rolique.intermate;

import org.apache.xml.utils.StringToIntTable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    JavascriptExecutor jse;
    String usrName = "oleksii@rolique.io";
    String usrPass = "secret";
    String instagramUsrName = "qa.rolique";
    String firstName = "QA";
    String lastName = "Rolique";
    String nickName = "Amalanamdas";
    String birthday = "17.07.2017";
    String profession = "QA Automation Engineer";
    String email = "mostovyi.oleksii@rolique.io";

    public void invokeBrowser(){

        try {
            System.setProperty("webdriver.chrome.driver", "D:\\SeleniumStudy\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.get("http:\\intermate.qa.rolique.space");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void enterCredentials() {
        try {
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/form/input[1]")).sendKeys(usrName);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/form/input[2]")).sendKeys(usrPass);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/form/button")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    public void createNewInfluencer(){
//        WebElement oWE = driver.findElement(By.xpath("//*[@id='root']/div/header/div[1]/div[3]/div/div/ul/li[1]"));
//        driver.findElement(By.xpath("//*[@id='root']/div/header/div[1]/div[3]/div/div/div/button[2]")).click();
//        try{
//            Actions oAction = new Actions(driver);
//
//            oAction.moveToElement(oWE);
//            Thread.sleep(5000);
//            oAction.contextClick(oWE).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        }catch (Exception e){
//            System.out.print(e);
//        }
//
//    }
    public void createNewInfluencer(){
        driver.findElement(By.xpath("//*[@id='root']/div/header/div[1]/div[3]/div/div/div/button[2]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div/header/div[1]/div[3]/div/div/ul/li[1]")).click();
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[1]/div[1]/input")).sendKeys(instagramUsrName);
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[2]/div[1]/input")).sendKeys(firstName);
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[2]/div[2]/input")).sendKeys(lastName);
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[2]/div[3]/input")).sendKeys(nickName);
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[2]/div[4]/div/button[1]")).click();
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[2]/div[5]/div/input")).sendKeys(birthday);
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[2]/div[6]/input")).sendKeys(birthday);
        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[2]/div[6]/input")).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[3]/div[1]/input")).sendKeys(email);
//        driver.findElement(By.xpath("html/body/div[5]/div/div/div/div[2]/form/div/div[3]/div[6]/select")).click();
    }

    public static void main(String[] args) {
        Login myObj = new Login();
        myObj.invokeBrowser();
        myObj.enterCredentials();
        myObj.createNewInfluencer();


    }

}
