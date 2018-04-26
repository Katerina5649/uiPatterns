package ru.mail.example.steps;

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

    /**
     * Проверяет заголовок страницы
     * @param header - заголовок страницы
     */
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                petsMilotaPage.getPageHeader());
    }

    /**
     * Реализация паттерна Action. Открывает страницу "Милота"
     * @param header - заголовок страницы
     */
    public void open(String header) {
        petsMilotaPage.open();
        petsMilotaPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    /**
     * Возвращает названия всех статей на странице
     * @return названия статей
     */
    public List<String> getAllArticlesTitles() {
        return petsMilotaPage.getAllArticlesTitles();
    }

    /**
     * Проверяет, что список статей на странице изменился
     * @param titles - названия статей
     */
    public void articlesTitlesShouldBeChanged(List<String> titles) {
        assertTrue("Список статей на странице должен измениться",
                petsMilotaPage.isArticlesTitlesChanged(titles));
    }
}
