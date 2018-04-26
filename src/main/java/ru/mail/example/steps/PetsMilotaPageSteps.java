package ru.mail.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.pages.PetsMilotaPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Набор шагов для взаимодействия со страницей "Милота"
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
public class PetsMilotaPageSteps extends AbstractSteps {

    private PetsMilotaPage petsMilotaPage = null;

    public PetsMilotaPageSteps(WebDriver driver) {
        super(driver);
        petsMilotaPage = PageFactory.initElements(driver, PetsMilotaPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header + "123456",
                petsMilotaPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        petsMilotaPage.open();
        petsMilotaPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Получаем названия всех статей на странице")
    public List<String> getAllArticlesTitles() {
        return petsMilotaPage.getAllArticlesTitles();
    }

    @Step("Проверяем, что список статей на странице изменился и не соответствует списку {titles}")
    public void articlesTitlesShouldBeChanged(List<String> titles) {
        assertTrue("Список статей на странице должен измениться",
                petsMilotaPage.isArticlesTitlesChanged(titles));
    }
}
