package pagespackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ru.mobileAvtomobilka.helperpackage.BasePageObject;

public class HeaderApp extends BasePageObject {
    public HeaderApp(AppiumDriver driver) {
        super(driver);
    }

    private By buttonSettingsHeader = By.id("top settings");
    private By buttonBackHeader = By.id("Back");
    private By buttonPlusHeader = By.id("plus");
    private By buttonCreate = By.id("Создать");
    private By buttonAdd = By.id("Добавить");
    private By buttonThreeDots = By.id("menu");
    private By popUpMenuWriteIntoJournal = By.id("Написать в журнал");
    private By popUpMenuEditAcar = By.id("Редактировать автомобиль");


    public HeaderApp clickButtonSettingsHeader() {
        System.out.println("\nTap button 'Settings'");
        click(buttonSettingsHeader);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonBackHeader() {
        System.out.println("\nTap button 'Back'");

        click(buttonBackHeader);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonPlusHeader() {
        System.out.println("\nTap button 'Plus'");

        click(buttonPlusHeader);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonCreate() {
        System.out.println("\nTap button 'Create'");

        click(buttonCreate);
        return new HeaderApp(driver);
    }


    public HeaderApp clickButtonThreeDots() {
        System.out.println("\nTap button with three dots");

        click(buttonThreeDots);
        return new HeaderApp(driver);
    }

    public HeaderApp clickPopUpMenuWriteIntoJournal() {
        System.out.println("\nTap  on 'Write into journal' in pop up menu");

        click(popUpMenuWriteIntoJournal);
        return new HeaderApp(driver);
    }

    public HeaderApp clickPopUpMenuEditAcar() {
        System.out.println("\nTap  on 'Edit a car' in pop up menu");

        click(popUpMenuEditAcar);
        return new HeaderApp(driver);
    }

    public HeaderApp clickButtonAddHeader() {
        System.out.println("\nTap  on 'Add'");

        click(buttonAdd);
        return new HeaderApp(driver);
    }


}
