package allure_example_github_issue_tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @DisplayName("Пример со steps и лямбдой")
    void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу Гитхаб", () -> {
            open("/");
        });
        step("Вводим в поле поиска "+REPOSITORY+" и enter", () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем на " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на вкладку issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем, что есть issue #80", () -> {
            $("div[aria-label=Issues]").$(withText("#80")).shouldBe(visible);
        });
        step("Код страницы", () -> {
            new BasicSteps().attachPageCode();
        });
        step("Скриншот", () -> {
            new BasicSteps().attachScreenshot();
        });
    }
}
