package tests.desktop;

import org.junit.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static enums.Constants.BASE_URL;
import static service.Utils.dCrlat;
import static service.Utils.genRandom;

public class Registration extends BaseTest {

    public static final String JOIN_NOW_BUTTON = dCrlat("joinNowButton");
    public static final String FIRST_NAME = dCrlat("firstName");
    public static final String LAST_NAME = dCrlat("lastName");
    public static final String DATE_OF_BIRTH_DAY = dCrlat("day");
    public static final String DATE_OF_BIRTH_MONTH = dCrlat("month");
    public static final String DATE_OF_BIRTH_YEAR = dCrlat("year");
    public static final String POST_CODE_UK = dCrlat("postcodeUk");
    public static final String FIND = dCrlat("reg.findBtn");
    public static final String MOBILE_NUMBER = dCrlat("mobile");
    public static final String EMAIl_ADDRESS = dCrlat("email");
    public static final String TITLE = dCrlat("socialTitle");
    public static final String ADDRESS1 = dCrlat("address1");
    public static final String ADDRESS2 = dCrlat("address2");
    public static final String ADDRESS3 = dCrlat("address3");
    public static final String CITY = dCrlat("city");
    public static final String CONFIRM_EMAIL = dCrlat("emailVerification");
    public static final String NEXT_STEP = dCrlat("nextStep");
    public static final String USERNAME = dCrlat("userName");
    public static final String PASSWORD = dCrlat("userPassword");
    public static final String CONFIRM_PASSWORD = dCrlat("passwordVerify");
    public static final String ACCOUNT_CURRENCY = dCrlat("selectCurrency");
    public static final String LIMIT_PERIOD = dCrlat("filterName");
    public static final String DEPOSIT_LIMIT = ".select-no-margin > .custom-select > select";
    public static final String TERMS_COND = dCrlat("label");
    public static final String COMPLETE_REGISTRATION = dCrlat("reg.submit");
    public static final String SPLASH_CONTENT = ".splash-content";
    public static final String SAVE_PREFERENCES = (".btn");
    public static final String CHECKBOX_ALL = dCrlat("label.all");


    @Test
    public void registration(){

        open(BASE_URL);
        $(JOIN_NOW_BUTTON).click();
        $(FIRST_NAME).setValue("Auto");
        $(LAST_NAME).setValue("Tester");
        $(DATE_OF_BIRTH_DAY).selectOption("10");
        $(DATE_OF_BIRTH_MONTH).selectOption("May");
        $(DATE_OF_BIRTH_YEAR).selectOption("1990");
        $(POST_CODE_UK).setValue("WR5 3DA");
        $(FIND).click();
        $(MOBILE_NUMBER).setValue("1234567");
        $(EMAIl_ADDRESS).setValue("test@playtech.com");
        $(CONFIRM_EMAIL).setValue("test@playtech.com");
        $(TITLE).selectOption("Miss");
        $(TITLE).selectOption("Miss");
        $(ADDRESS1).setValue("12334");
        $(ADDRESS2).setValue("12334");
        $(ADDRESS3).setValue("12334");
        $(CITY).setValue("Lviv");
        $(NEXT_STEP).click();
        $(USERNAME).setValue("Auto_tester" + genRandom);
        $(PASSWORD).setValue("123456test");
        $(CONFIRM_PASSWORD).setValue("123456test");
        $(ACCOUNT_CURRENCY).selectOption("USD");
        $(LIMIT_PERIOD).click();
        $(DEPOSIT_LIMIT).selectOption("75000");
        $(TERMS_COND).click();
        $(COMPLETE_REGISTRATION).click();
        $(CHECKBOX_ALL).click();
        $(SAVE_PREFERENCES).click();

    }

}
