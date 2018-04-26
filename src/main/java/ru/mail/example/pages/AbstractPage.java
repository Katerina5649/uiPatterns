package ru.mail.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.example.navigation.PageObject;

/**
 * Паттерн Base Page
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
public abstract class AbstractPage extends PageObject {

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement header;

    /**
     * Возвращает заголовок страницы
     * @return заголовок страницы
     */
    public String getPageHeader() {
        return header.getText();
    }

    /**
     * JavaScript Executor
     * @return executor
     */
    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    /**
     * Открывает страницу
     */
    public void open() {
        getDriver().get(getPageUrl());
    }
}
