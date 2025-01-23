package extended;

import extended.pages.HomePage;
import extended.pages.WebFormPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Feature("SmokeUiTests")
@Tag("ui")
@Tag("smoke")
class SmokeUiTests {
    HomePage homePage;

    @BeforeEach
    void setup() {
        homePage = new HomePage(new ChromeDriver());
    }

    @AfterEach
    void tearDown() {
        homePage.quit();
    }

    @Test
    @DisplayName("Check form submitted and has title")
    void submitWebFormTest() {
        WebFormPage webFormPage = homePage.openWebForm();

        webFormPage.fillTextInput("Text");
        webFormPage.submitForm();
        WebElement title = webFormPage.getTitle();

        Assertions.assertEquals("Form submitted", title.getText());
    }
}
