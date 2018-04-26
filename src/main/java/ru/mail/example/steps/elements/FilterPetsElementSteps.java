package ru.mail.example.steps.elements;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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
@DisplayName("Test steps")
public class FilterPetsElementSteps extends AbstractSteps {

    public FilterPetsElementSteps(WebDriver driver) {
        super(driver);
    }

    private FilterPetsElement filterPetsElement = null;

    private FilterPetsElement getFilterPetsElement() {
        if(filterPetsElement == null) filterPetsElement = PageFactory.initElements(getDriver(), FilterPetsElement.class);
        return filterPetsElement;
    }

    @Step("Проверяем, что вкладка {petsData.getName} активна в фильтре")
    public void filterTabShouldBeActive(PetsData petsData) {
        assertTrue(String.format("Вкладка фильтра %s должна быть активна", petsData.getName()),
                getFilterPetsElement().isFilterTabActive(petsData));
    }

    @Step("Проверяем, что вкладка {petsData.getName} не активна в фильтре")
    public void filterTabShouldNotBePresent(PetsData petsData) {
        assertTrue(String.format("Вкладка фильтра %s не должна быть активна", petsData.getName()),
                getFilterPetsElement().isFilterTabNotActive(petsData));
    }

    @Step("Кликаем на вкладку {petsData.getName}")
    public void clickFilterTab(PetsData petsData) {
        getFilterPetsElement().clickFilterTab(petsData);
    }
}