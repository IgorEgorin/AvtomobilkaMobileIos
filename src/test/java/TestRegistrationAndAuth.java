import org.junit.Test;
import ru.mobileAvtomobilka.helperpackage.BaseTest;
import ru.mobileAvtomobilka.helperpackage.DataForUser;

public class TestRegistrationAndAuth extends BaseTest {


    @Test
    public void registrateRandomUser() throws Exception{

        tabsFooter.clickOntabRegAndAuth()
                .tapRegistrationButton()
                .enterLogInAndPass(DataForUser.varRandomMail,DataForUser.varRandomPassword);

        editProfileScreen.enterUserNameAndSubmit(DataForUser.varRandomUserName);


        Thread.sleep(10000);
    }
}
