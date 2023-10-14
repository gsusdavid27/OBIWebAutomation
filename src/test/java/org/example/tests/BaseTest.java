package org.example.tests;

import org.example.MyDriver;
import org.example.InfoReporter;
import org.example.models.User;
import org.example.pages.microsoft.MicrosoftSSOPage;
import org.example.pages.agreement.AgreementListPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest extends InfoReporter {
    // Ruta relativa para el archivo de propiedades
    public static final String CONFIG_PROPERTIES = "src/test/java/org/example/resources/properties/config.properties";

    private User currentUser;
    private MicrosoftSSOPage microsoftSSOPage;
    private AgreementListPage agreementListPage;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "environment"})
    public void beforeSuite(String browser, String environment) {
        try {
            logInfo("### Reading Environment Properties File ###");
            Properties properties = new Properties();
            properties.load(new FileInputStream(CONFIG_PROPERTIES));
            String url = properties.getProperty(environment + ".url");
            String username = properties.getProperty(environment + ".username");
            String password = properties.getProperty(environment + ".password");
            currentUser = new User(username, password);
            logInfo("Browser: "+browser);

            // Utiliza el Singleton de MyDriver para obtener el controlador de WebDriver
            MyDriver md = MyDriver.getInstance(browser);
            WebDriver driver = md.getDriver();
            driver.manage().window().maximize();

            logInfo("Staring MainTask - HomePage");
            microsoftSSOPage = new MicrosoftSSOPage(url);
        } catch (IOException e) {
            logError("Fail Reading Environment Properties");
        }
    }

    @BeforeTest(alwaysRun = true)
    public void login() {
        agreementListPage = microsoftSSOPage.doSSO(currentUser.getUsername(), currentUser.getPassword());
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        MyDriver.getInstance("").closeDriver(); // Cerrar el controlador utilizando el Singleton de MyDriver
    }

    public AgreementListPage getAgreementListPage() {
        return agreementListPage;
    }
}
