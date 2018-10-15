package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

public class InfoStartScreen extends BasePageObject {
    public InfoStartScreen(AppiumDriver driver) {
        super(driver);
    }

    private By buttonSkipInfo = By.id("Пропустить");


    public InfoStartScreen clickButtonSkipInfo() {
        click(buttonSkipInfo);
        return new InfoStartScreen(driver);
    }
}
