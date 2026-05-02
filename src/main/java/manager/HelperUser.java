package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.cssSelector("a.navigation-link[href*='login']"));
//        loginTab.click();
        click(By.cssSelector("a.navigation-link[href*='login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.xpath("//*[@id='email']"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.xpath("//*[@id='email']"), email);

//        WebElement passwordInput = wd.findElement(By.xpath("//input[@id='password']"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys();
        type(By.xpath("//input[@id='password']"), password);

    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Y’alla!']"));

    }
}
