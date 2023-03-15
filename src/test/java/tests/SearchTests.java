package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;


public class SearchTests extends TestBase {

    @DisplayName("Checking search of java")
    @Test
    @Tag("Android")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("Android")
    @DisplayName("Checking 'About' in settings")
    void searchAboutTest() {
        step("Open menu", () ->
                $(id("org.wikipedia.alpha:id/menu_overflow_button")).click()
        );

        step("Open settings", () ->
                $(id("org.wikipedia.alpha:id/explore_overflow_settings")).click()
        );

        step("Verify 'About'", () -> {
            $(xpath(("//*[@text='About']"))).shouldBe(visible);
        });
    }

    @DisplayName("Checking search of java")
    @Test
    @Tag("iOS")
    void successfulSearchIosTest() {
        step("Type search", () -> {
            $(xpath("/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSegmentedControl/XCUIElementTypeButton[2]")).click();
        });
        step("Verify content found", () ->
                $(xpath(("/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable"))).shouldBe(visible));
    }
}