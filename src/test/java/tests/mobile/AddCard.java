package tests.mobile;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static service.Utils.dCrlat;
import static service.Utils.dUAT;

public class AddCard extends BaseTest {

    String FRAME = "addCardIframe";
    String CARDHOLDER_NAME = "#cc_name_on_card";
    String CARD_NUMBER = "#cc_card_number";
    String EXPIRY_MONTH = "#cc_exp_month";
    String EXPIRY_YEAR = "#cc_exp_year";
    String REGISTER = "#continueButton";
    String SUCCESS_MESSAGE = dCrlat("infoPanel.message");

    @Test
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

}
