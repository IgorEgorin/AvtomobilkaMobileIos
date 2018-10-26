import org.junit.Test;
import ru.mobileAvtomobilka.helperpackage.BaseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecoveryPassword extends BaseTest {

    @Test
    public void recoveryPass() throws InterruptedException {

        footerApp.clickOntabRegAndAuthScreen();

        openSafariDropMailPage();


        setUp();

        Thread.sleep(99999999);
//        footerApp.logInLikeNewUser();
//
//        userCabinet.logOutFromUserCabinet();
//
//        footerApp.clickOntabRegAndAuthScreen()
//                .tabButtonForgetApassword()
//                .enterMailInfieldForPasswordRecovery(varRandomMail);

    }

}
