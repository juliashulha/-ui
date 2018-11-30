package tests.desktop;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import service.Order;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static enums.Constants.BASE_URL;
import static service.Utils.dCrlat;
import static service.Utils.dUAT;

public class Login extends BaseTest {





    @Test
    @Order(order = 1)
    public static void login(){
                open(BASE_URL);
                $(dCrlat("signInButton")).click();
                $(dCrlat("username")).setValue("Auto_tester59");
                $(dCrlat("password")).setValue("123456test");
                $("#log-form > form > div:nth-child(7) > button").click();
                $(dUAT("popUpText")).isDisplayed();
                $(dUAT("popUpText")).shouldHave(Condition.text("Auto_tester59"));
    }





}