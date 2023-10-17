package org.example.components.tests.suite.smoke;

import org.example.components.pages.microsoft.MicrosoftSignInPage;
import org.example.components.tests.BaseTest;
import org.testng.annotations.Test;

public class MicrosoftSignInTest extends BaseTest {

    @Test
    private void loginToApplication() {
        MicrosoftSignInPage microsoftSignInPage = new MicrosoftSignInPage(super.url);
        microsoftSignInPage
                .doSSO(currentUser.getUsername(),
                        currentUser.getPassword());
    }

}
