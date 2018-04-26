package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.example.data.PetsData;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.steps.PetsMilotaPageSteps;
import ru.mail.example.steps.elements.FilterPetsElementSteps;

import java.util.Arrays;
import java.util.List;

/**
 * Проверяем клил по плитке статьи на странице /milota проекта "Питомцы"
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
@DisplayName("Проверяем клил по плитке статьи на странице /milota проекта \"Питомцы\"")
public class ClickCatsPetsMilotaFilterTab_Test {

    private DriverProvider driverProvider = null;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void click_milota_filter_cats_pet_tab() {
        //Открываем страницу "Милота"
        PetsMilotaPageSteps petsMilotaPageSteps = new PetsMilotaPageSteps(driverProvider.getDriver());
        petsMilotaPageSteps.open("Милота");

        //Получаем названия всех статей на странице
        List<String> titles = petsMilotaPageSteps.getAllArticlesTitles();

        //Проверяем, что вкладка "Все активна"
        FilterPetsElementSteps filterPetsElementSteps = new FilterPetsElementSteps(driverProvider.getDriver());
        filterPetsElementSteps.filterTabShouldBeActive(PetsData.All);

        //Кликаем на вкладку "Кошки"
        filterPetsElementSteps.clickFilterTab(PetsData.Cats);

        //Проверяем, что вкладка "Кошки" активна
        filterPetsElementSteps.filterTabShouldBeActive(PetsData.Cats);

        //Проверяем, что остальные вкладки не активны
        Arrays.stream(PetsData.values())
                .filter(pet -> pet != PetsData.Cats)
                .forEach(pet -> filterPetsElementSteps.filterTabShouldNotBePresent(pet));

        //Проверяем, что список статей на странице изменился
        petsMilotaPageSteps.articlesTitlesShouldBeChanged(titles);
    }
}