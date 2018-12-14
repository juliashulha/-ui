package tests.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.openqa.selenium.By;
import service.Order;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.jayway.restassured.RestAssured.given;
import static enums.Constants.BASE_URL;
import static service.Utils.dCrlat;
import static service.Utils.dUAT;
import static service.Utils.genRandom;

public class Registration extends BaseTest {

    public Response response;

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
    public static final String TERMS_COND ="#registrationMobile3 > div:nth-child(7) > div > div > div.col-xs-1.col-md-1 > div > label";
    public static final String COMPLETE_REGISTRATION = dCrlat("reg.submit");
    public static final String SPLASH_CONTENT = ".splash-content";
    public static final String SAVE_PREFERENCES = (".btn");
    public static final String CHECKBOX_ALL = dCrlat("label.all");



    //Login
    String USERNAME_V = "Auto_tester" + genRandom;

    //Add card
    String FRAME = "addCardIframe";
    String CARDHOLDER_NAME = "#cc_name_on_card";
    String CARD_NUMBER = "#cc_card_number";
    String EXPIRY_MONTH = "#cc_exp_month";
    String EXPIRY_YEAR = "#cc_exp_year";
    String REGISTER = "#continueButton";
    String SUCCESS_MESSAGE = dCrlat("infoPanel.message");


    //Deposit
     String AMOUNT = dCrlat("enterAmount");
     String CVV = dCrlat("cvv2");
     String SUBMIT = dCrlat("submit");
     String DIALOG = dCrlat("dialog.accept");
     String BALANCE = dCrlat("balanceAmount");


    @Test
    @Order(order = 1)
    public void registration() throws InterruptedException {

        System.out.println(USERNAME_V);

        open(BASE_URL);
        $(JOIN_NOW_BUTTON).click();
        $(FIRST_NAME).setValue("Auto");
        $(LAST_NAME).setValue("Tester");
        $(DATE_OF_BIRTH_DAY).selectOption("10");
        $(DATE_OF_BIRTH_MONTH).selectOption("May");
        $(DATE_OF_BIRTH_YEAR).selectOption("1990");
        $(NEXT_STEP).click();
        $(POST_CODE_UK).setValue("WR5 3DA");
        $(FIND).click();
        $(MOBILE_NUMBER).setValue("1234567");
        $(EMAIl_ADDRESS).setValue("test@playtech.com");
        $(NEXT_STEP).click();
        $(ADDRESS1).setValue("12334");
        $(ADDRESS2).setValue("12334");
        $(ADDRESS3).setValue("12334");
        $(CITY).setValue("Lviv");
        $(NEXT_STEP).click();
        $(USERNAME).setValue(USERNAME_V);
        $(PASSWORD).setValue("123456test");
        $(TERMS_COND).click();
        $(COMPLETE_REGISTRATION).click();
//        $(url()).shouldHave(Condition.attribute("/deposit/addcard"));
//        $(CHECKBOX_ALL).click();
//        $(SAVE_PREFERENCES).click();

    }

    @Test
    @Order(order = 2)
    public void login() {
        open(BASE_URL);
        $(dCrlat("signInButton")).click();
        $(dCrlat("username")).setValue(USERNAME_V);
        $(dCrlat("password")).setValue("123456test");
        $("#log-form > form > div:nth-child(7) > button").click();
//        $(dUAT("popUpText")).isDisplayed();
//        $(dUAT("popUpText")).shouldHave(Condition.text(USERNAME_V));
//        $(dUAT("popUpButton")).click();
//        open("/deposit/addcard");
//        switchTo().frame(FRAME);
//        $(CARDHOLDER_NAME).setValue("Auto Tester");
//        $(CARD_NUMBER).setValue("Auto 4532279700741928");
//        $(EXPIRY_MONTH).selectOption("12");
//        $(EXPIRY_YEAR).selectOption("2021");
//        $(REGISTER).click();
//        switchTo().defaultContent();
//        $(SUCCESS_MESSAGE).should(Condition.text("Your card was added successfully."));
//
//        open("/deposit/registered");
//        $(AMOUNT).setValue("6.55");
//        $(CVV).setValue("123");
//        $(SUBMIT).click();
//        $(DIALOG).click();
//        $(SUCCESS_MESSAGE).shouldHave(Condition.text("£6.55"));
//        $(BALANCE).should(Condition.text("£6.55"));
//
//        open("/home/multiples");
//        $("[class=\"lc-offer__link\"]").find("");
    }

//    @Test
    @Order(order = 3)
    public void deposit(){

        open(BASE_URL+ "/deposit/registered");
        $(AMOUNT).setValue("6.55");
        $(CVV).setValue("123");
        $(SUBMIT).click();
        $(DIALOG).click();
        $(SUCCESS_MESSAGE).shouldHave(Condition.text("£6.55"));
        $(BALANCE).should(Condition.text("£6.55"));

    }


//    @Test
    public void getEvents(){

        response=
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("https://ss-aka-ori.coral.co.uk/openbet-ssviewer/Drilldown/2.26/Event/?simpleFilter=event.siteChannels:contains:M&simpleFilter=event.suspendAtTime:greaterThan:2018-11-30T11:44:00.000Z&simpleFilter=event.typeName:equals:|Enhanced%20Multiples|&translationLang=en")
                .then()
                .log().all()
                .extract().response();

        JsonPath jp = response.jsonPath();
        String id = jp.getObject("SSResponse.children[\"\"0\"\"].event.children[\"\"0\"\"].market.children[\"\"0\"\"].outcome.id", String.class);

        System.out.println(id);

    }

}
