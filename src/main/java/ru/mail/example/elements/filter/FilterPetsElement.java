package ru.mail.example.elements.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.example.data.PetsData;
import ru.mail.example.elements.Component;
import ru.mail.example.elements.ComponentObject;

/**
 * Фильтр статей животных на странице
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
@Component(xpath = "//*[contains(@class, 'filter__list')]")
public class FilterPetsElement extends ComponentObject {

    public FilterPetsElement(WebDriver driver) {
        super(driver);
    }

    private final String petsFilterTabLocator = "//a[contains(@class, 'filter__item')][.//span[@class='filter__text'][text()='%s']]";

    /**
     * Проверяет, что вкладка в фильтре активна
     * @param petsData - вкладка
     * @return boolean
     */
    public boolean isFilterTabActive(PetsData petsData) {
        String locator = String.format(petsFilterTabLocator, petsData.getName());
        return waitTools.waitForCondition(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active"));
    }

    /**
     * Проверяет, что вкладка в фильтре не активна
     * @param petsData - вкладка
     * @return boolean
     */
    public boolean isFilterTabNotActive(PetsData petsData) {
        String locator = String.format(petsFilterTabLocator, petsData.getName());
        return waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active")));
    }

    /**
     * Кликает на вкладку фильтра
     * @param petsData - вкладка
     */
    public void clickFilterTab(PetsData petsData) {
        String locator = String.format(petsFilterTabLocator, petsData.getName());
        getDriver().findElement(By.xpath(locator)).click();
    }
}
