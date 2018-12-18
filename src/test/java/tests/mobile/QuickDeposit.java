package tests.mobile;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import service.Order;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static enums.Constants.BASE_URL;
import static service.Utils.dCrlat;
import static service.Utils.dUAT;

public class QuickDeposit extends BaseTest {

    String AMOUNT = dCrlat("enterAmount");
    String CVV = dCrlat("cvv2");
    String SUBMIT_DEPOSIT = dCrlat("submit");
    String DIALOG = dCrlat("dialog.accept");
    String BALANCE = dCrlat("balanceAmount");
    String SUCCESS_MESSAGE = dCrlat("balanceAmount");
    String POPUP = dUAT("popUpWindow");
    String POPUP_CLOSE_BTN = dUAT("popUpCloseButton");

    @Test
    @Order(order = 1)
    public void deposit() throws InterruptedException {
        Login.login();
        Thread.sleep(2000);
        open(BASE_URL+ "/deposit/registered");
        $(AMOUNT).setValue("6.55");
        $(CVV).setValue("123");
        $(SUBMIT_DEPOSIT).click();
        $(DIALOG).click();
        $(SUCCESS_MESSAGE).shouldHave(Condition.text("£6.55"));
        boolean popup = $(POPUP).isDisplayed();
        if (popup == true) {
            $(POPUP_CLOSE_BTN).click();
        }
        $(BALANCE).should(Condition.text("£6.55"));

    }




}
