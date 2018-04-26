package ru.mail.example.steps.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.data.PetsData;
import ru.mail.example.elements.filter.FilterPetsElement;
import ru.mail.example.steps.AbstractSteps;

import static org.junit.Assert.assertTrue;

/**
 * Компонент фильтра на странице. Паттерн Component Object.
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
public class FilterPetsElementSteps extends AbstractSteps {

    public FilterPetsElementSteps(WebDriver driver) {
        super(driver);
    }

    private FilterPetsElement filterPetsElement = null;

    private FilterPetsElement getFilterPetsElement() {
        if(filterPetsElement == null) filterPetsElement = PageFactory.initElements(getDriver(), FilterPetsElement.class);
        return filterPetsElement;
    }

    /**
     * Проверяет, что вкладка в фильтре активна
     * @param petsData - вкладка фильтра
     */
    public void filterTabShouldBeActive(PetsData petsData) {
        assertTrue(String.format("Вкладка фильтра %s должна быть активна", petsData.getName()),
                getFilterPetsElement().isFilterTabActive(petsData));
    }

    /**
     * Проверяет, что вкладка в фильтре не активна
     * @param petsData - вкладка фильтра
     */
    public void filterTabShouldNotBePresent(PetsData petsData) {
        assertTrue(String.format("Вкладка фильтра %s не должна быть активна", petsData.getName()),
                getFilterPetsElement().isFilterTabNotActive(petsData));
    }

    /**
     * Кликает на вкладку в фильтре
     * @param petsData - вкладка
     */
    public void clickFilterTab(PetsData petsData) {
        getFilterPetsElement().clickFilterTab(petsData);
    }
}