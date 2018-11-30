package tests.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.junit.runner.RunWith;
import service.Order;
import service.OrderedRunner;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static enums.Constants.BASE_URL;
import static service.Utils.dCrlat;
import static service.Utils.dUAT;

@RunWith(OrderedRunner.class)
public class Login extends BaseTest {

    String FRAME = "addCardIframe";
    String CARDHOLDER_NAME = "#cc_name_on_card";
    String CARD_NUMBER = "#cc_card_number";
    String EXPIRY_MONTH = "#cc_exp_month";
    String EXPIRY_YEAR = "#cc_exp_year";
    String REGISTER = "#continueButton";
    String SUCCESS_MESSAGE = dCrlat("infoPanel.message");

    @Test
    @Order(order = 1)
    public void login() {
        open(BASE_URL);
        $(dCrlat("signInButton")).click();
        $(dCrlat("username")).setValue("Auto_tester358");
        $(dCrlat("password")).setValue("123456test");
        $("#log-form > form > div:nth-child(7) > button").click();
        $(dUAT("popUpText")).isDisplayed();
        $(dUAT("popUpText")).shouldHave(Condition.text("Auto_tester358"));
        $(dUAT("popUpButton")).click();
        open("/deposit/addcard");
        switchTo().frame(FRAME);
        $(CARDHOLDER_NAME).setValue("Auto Tester");
        $(CARD_NUMBER).setValue("Auto 4532279700741928");
        $(EXPIRY_MONTH).selectOption("12");
        $(EXPIRY_YEAR).selectOption("2021");
        $(REGISTER).click();
        switchTo().defaultContent();
        $(SUCCESS_MESSAGE).should(Condition.text("Your card was added successfully."));
    }

//    @Test
    @Order(order = 2)
    public void addCard(){

        $(dUAT("popUpButton")).click();
        open("/deposit/addcard");
        switchTo().frame(FRAME);
        $(CARDHOLDER_NAME).setValue("Auto Tester");
        $(CARD_NUMBER).setValue("Auto 4532279700741928");
        $(EXPIRY_MONTH).selectOption("12");
        $(EXPIRY_YEAR).selectOption("2021");
        $(REGISTER).click();
        switchTo().defaultContent();
        $(SUCCESS_MESSAGE).should(Condition.text("Your card was added successfully."));

    }

//    @Test
    @Order(order = 2)
    public void deposit() {
        {

        }
    }

}