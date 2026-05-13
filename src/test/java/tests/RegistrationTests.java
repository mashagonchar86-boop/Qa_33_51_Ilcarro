package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }



    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        System.out.println(i);
        System.out.println("=========================");

        int z = (int) ((System.currentTimeMillis()/1000)%3600);

        System.out.println(System.currentTimeMillis());
        System.out.println(z);

        User user = new User()
                .setName("David")
                .setLastName("Snow")
                .setEmail("snow"+z+"@gmail.com")
                .setPassword("m341339182P$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }

    @Test
    public void registrationEmptyName(){
        User user = new User()
                .setName("")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Snow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationEmptyLastName(){
        User user = new User()
                .setName("Vera")
                .setLastName("")
                .setEmail("snow@gmail.com")
                .setPassword("Snow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void registrationWrongEmail(){
        User user = new User()
                .setName("Davis")
                .setLastName("Snow")
                .setEmail("snow11111111gmail.com")
                .setPassword("m341339182P$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void registrationEmptyEmail(){
        User user = new User()
                .setName("J Lo")
                .setLastName("Snow")
                .setEmail("")
                .setPassword("m341339182P$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }


    @Test
    public void registrationWrongPassword(){
        User user = new User()
                .setName("Dave")
                .setLastName("Snow")
                .setEmail("snow11111111@gmail.com")
                .setPassword("1");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }


    @Test
    public void registrationEmptyPassword(){
        User user = new User()
                .setName("Jennifer")
                .setLastName("Snow")
                .setEmail("snow11111111@gmail.com")
                .setPassword("");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }











    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }




}
