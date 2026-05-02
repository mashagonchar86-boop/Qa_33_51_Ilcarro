package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("roma123@gmail.com", "m341339182P$");
        app.getHelperUser().submitLogin();

    }
}
