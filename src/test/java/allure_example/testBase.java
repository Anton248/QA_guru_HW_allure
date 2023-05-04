package allure_example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class testBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";  //site to test
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true; // show browser to test the tests themselves

    }
}
