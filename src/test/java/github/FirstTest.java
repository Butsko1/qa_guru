package github;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.BasicAuthCredentials;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Time;

public class FirstTest {
    @Test
    void firstTestMethod(){
        open("https://github.com/");
        $("[class=\"search-input-container search-with-dialog position-relative d-flex flex-row flex-items-center mr-4 rounded\"]").click();
        $("[name=\"query-builder-test\"]").setValue("selenide").pressEnter();
        $("[data-testid=\"results-list\"]").$("[class=\"Link__StyledLink-sc-14289xe-0 GCHqa\"]").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

    @Test
    void secondTestMethod(){
        open("https://github.com/selenide/selenide");
        $("div.BorderGrid-cell ul").$$("li a").first().hover();
        $("a.Link--secondary.no-underline.ml-1").shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void thirdMethod() {
        open("https://github.com/");
        $$("button.HeaderMenu-link").get(1).hover();
        $("div.border-bottom ul").$$("li a").get(0).shouldHave(text("Enterprise"));
        $("div.border-bottom ul").$$("li a").get(0).click();
        webdriver().shouldHave(WebDriverConditions.url("https://github.com/enterprise"));
        sleep(5000);
    }

    @Test
    void fourthMethod(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(2000);
        $("#column-a").dragAndDropTo("#column-b");
        sleep(2000);
        $$("div#columns div header").get(0).shouldHave(text("B"));
    }

    @Test
    void fifthMethod(){
        Assertions.assertTrue(3 > 2);
    }
}
