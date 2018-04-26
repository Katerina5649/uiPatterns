package ru.mail.example.steps;

import org.openqa.selenium.WebDriver;
import ru.mail.example.navigation.PageObject;

/**
 * Абстрактные Шаги
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
public abstract class AbstractSteps extends PageObject {

    public AbstractSteps(WebDriver driver) {
        super(driver);
    }
}
