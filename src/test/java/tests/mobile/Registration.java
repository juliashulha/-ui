package tests.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import service.Order;
import service.OrderedRunner;
import tests.BaseTest;

import javax.crypto.Mac;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.jayway.restassured.RestAssured.given;
import static enums.Constants.BASE_URL;
import static service.Utils.dCrlat;
import static service.Utils.dUAT;
import static service.Utils.genRandom;

@RunWith(OrderedRunner.class)
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
    public static final String ADDRESS1 = dCrlat("address1");
    public static final String ADDRESS2 = dCrlat("address2");
    public static final String ADDRESS3 = dCrlat("address3");
    public static final String CITY = dCrlat("city");
    public static final String NEXT_STEP = dCrlat("nextStep");
    public static final String USERNAME = dCrlat("userName");
    public static final String PASSWORD = dCrlat("userPassword");
    public static final String TERMS_COND = "input[name='termsAndConditions']";
    public static final String COMPLETE_REGISTRATION = dCrlat("reg.submit");
    public static final String MY_BET_BUTTON = dCrlat("myBetsBtn");
    public static final String TITLE_TEXT = dCrlat("titleText");
    public static final String POPUP_BUTTON = dCrlat("acceptTermsButton");

    public static final String CLOSE_WELCOME_POPUP = String.valueOf(By.xpath("//*[@id=\"close-icon\"]/path"));
    public static final String TUTORIAL_OVERLAY = dCrlat("tutorialOverlay");
    public static final String CLOSE_TUTORIAL_BUTTON = dCrlat("closeTutorialBtn");
    public static final String WELCOME_POPUP_TEXT = dCrlat("text");


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
    String CONTINUE_BUTTON = "btnSubmit";
    String SUCCESS_MESSAGE = dCrlat("infoPanel.message");


    //Deposit
     String AMOUNT = dCrlat("enterAmount");
     String CVV = dCrlat("cvv2");
     String SUBMIT_DEPOSIT = "//button[@type='submit']";
     String DIALOG = dCrlat("dialog.accept");
     String BALANCE = dCrlat("rightMenuBtn");
     String POPUP = dUAT("popUpWindow");
     String POPUP_CLOSE_BTN = dUAT("popUpCloseButton");


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
        $(TERMS_COND).parent().click();
        $(COMPLETE_REGISTRATION).click();

        Thread.sleep(7000);

//        $(TITLE_TEXT).shouldBe(Condition.attribute("DEPOSIT"));
//        $(MY_BET_BUTTON).click();
//        $(url()).shouldHave(Condition.attribute("/deposit/addcard"));
//        $(CHECKBOX_ALL).click();
//        $(SAVE_PREFERENCES).click();

    }

    @Test
    @Order(order = 2)
    public void login(){
        open(BASE_URL);
        $(dCrlat("signInButton")).click();
        $(dCrlat("username")).setValue(USERNAME_V);
//        $(dCrlat("username")).setValue("Auto_tester46165");
        $(dCrlat("password")).setValue("123456test");
        $("#log-form > form > div:nth-child(7) > button").click();
        boolean panel = $(dCrlat("panelButtons")).isDisplayed();
        if (panel==true){
            $(dCrlat("panelButtons")).click();
        }
//        $(POPUP_BUTTON).isDisplayed();
//        $(CLOSE_WELCOME_POPUP).click();
//
//        $(WELCOME_POPUP_TEXT).isDisplayed();
//        $(WELCOME_POPUP_TEXT).shouldHave(Condition.text(USERNAME_V));
//        $(TUTORIAL_OVERLAY).isDisplayed();
//        $(CLOSE_TUTORIAL_BUTTON).click();

    }
        @Test
        @Order(order = 3)
        public void addCard () throws InterruptedException {
            login();
            Thread.sleep(2000);
            open(BASE_URL + "/deposit/addcard");
            switchTo().frame(FRAME);
            $(CARDHOLDER_NAME).setValue("Auto Tester");
            $(CARD_NUMBER).setValue("4532279700741928");
            $(EXPIRY_MONTH).selectOption("12");
            $(EXPIRY_YEAR).selectOption("2021");
            $(By.name(CONTINUE_BUTTON)).click();
            switchTo().defaultContent();
//            $(SUCCESS_MESSAGE).should(Condition.text("Your card was added successfully."));
    }

    @Test
    @Order(order = 4)
    public void deposit() throws InterruptedException {
        login();
        Thread.sleep(2000);
        open(BASE_URL+ "/deposit/registered");
        $(AMOUNT).setValue("6.55");
        $(CVV).setValue("123");
        $(By.xpath(SUBMIT_DEPOSIT)).click();
        $(DIALOG).click();
        boolean popup = $(POPUP).isDisplayed();
        if (popup) {
            $(POPUP_CLOSE_BTN).click();
        }
        $(SUCCESS_MESSAGE).shouldHave(Condition.text("£6.55"));
        $(BALANCE).shouldBe(Condition.text("£6.55"));

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

//        JsonPath jp = response.jsonPath();
//        String id = jp.getObject("SSResponse.children[\"\"0\"\"].event.children[\"\"0\"\"].market.children[\"\"0\"\"].outcome.id", String.class);

        System.out.println(response.asString());

    }

}
