package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

public class TabsFooter extends BasePageObject {
    public TabsFooter(AppiumDriver driver) {
        super(driver);
    }

    private By tabRegAndAuth = By.xpath("//XCUIElementTypeButton[4]");


    public RegistarationAndAuthorizationScreen clickOntabRegAndAuth() {
        click(tabRegAndAuth);
        return new RegistarationAndAuthorizationScreen(driver);
    }


}
