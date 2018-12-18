package tests.mobile;

import org.junit.Test;
import org.junit.runner.RunWith;
import service.Order;
import service.OrderedRunner;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static enums.Constants.BASE_URL;
import static service.Utils.dCrlat;

@RunWith(OrderedRunner.class)
public class Login extends BaseTest {

    @Order(order = 1)
    public static void login() {
        open(BASE_URL);
        $(dCrlat("signInButton")).click();
//        $(dCrlat("username")).setValue(USERNAME_V);
        $(dCrlat("username")).setValue("Auto_tester46366");
        $(dCrlat("password")).setValue("123456test");
        $("#log-form > form > div:nth-child(7) > button").click();
        $(dCrlat("panelButtons")).click();
//        $(POPUP_BUTTON).isDisplayed();
//        $(CLOSE_WELCOME_POPUP).click();
//
//        $(WELCOME_POPUP_TEXT).isDisplayed();
//        $(WELCOME_POPUP_TEXT).shouldHave(Condition.text(USERNAME_V));
//        $(TUTORIAL_OVERLAY).isDisplayed();
//        $(CLOSE_TUTORIAL_BUTTON).click();

    }
}