package manager;

import models.User;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;


public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
//        WebElement loginTab = wd.findElement(By.cssSelector("a.navigation-link[href*='login']"));
//        loginTab.click();
        click(By.cssSelector("a.navigation-link[href*='login']"));
    }

    public void fillLoginForm(String email, String password) {
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

    public void submit() {
        click(By.xpath("//button[@type='submit']"));

    }

    public boolean isLogged() {

        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
//        pause(5000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }


    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));
        WebElement element = wd.findElement(By.cssSelector("button[type = 'submit']"));
        boolean result = element.isEnabled();

        return res && !result;
    }


    // registration
    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getEmail());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));
        //click(By.cssSelector("label[for='terms-of-use']"));

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
    }

    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rectangle = label.getRect();
        int w = (int) rectangle.getWidth();

        //Dimension size = wd.manage().window().getSize();
        int xOffset = -w/2;
        Actions actions = new Actions(wd);

        actions.moveToElement(label, xOffset, 0).click().release().perform();

    }
}







