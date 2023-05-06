package allure_example_github_issue_tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class RawSelenideTest extends TestBase{

    @Test
    @DisplayName("Пример без steps, только c Listener")
    void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/"); //opening Github
        $(".header-search-input").setValue("eroshenkoam/allure-example")
                .pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("div[aria-label=Issues]").$(withText("#80")).shouldBe(visible);
        new BasicSteps().attachPageCode();
        new BasicSteps().attachScreenshot();
    }
}
