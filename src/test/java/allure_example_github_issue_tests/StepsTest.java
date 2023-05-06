package allure_example_github_issue_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest extends TestBase{

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @DisplayName("Пример со steps, вынесенных в отдельный класс")
    void searchIssueTest() {

        BasicSteps steps = new BasicSteps();

        steps.openMainPage();
        steps.searching(REPOSITORY);
        steps.clickLink(REPOSITORY);
        steps.clickIssuesTab();
        steps.issue80ShouldBeVisible();
        steps.attachPageCode();
        steps.attachScreenshot();

    }
}
