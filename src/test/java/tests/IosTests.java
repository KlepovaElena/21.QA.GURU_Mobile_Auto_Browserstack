package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;

public class IosTests extends TestBase {

    @Test
    @Tag("ios")
    @DisplayName("Проверка результата поиска Quality Assurance")
    void iosSearchTest() {
        step("Ввод в поле Quality assurance", () -> {
            $(accessibilityId("Text Button")).click();
            $(accessibilityId("Text Input")).sendKeys("Quality assurance");
        });
        step("Проверка отображения результатов", () -> {
            $(accessibilityId("Text Output")).shouldHave(Condition.text("Quality assurance"));
        });
    }
}