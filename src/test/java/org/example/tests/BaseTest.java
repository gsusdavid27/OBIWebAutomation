package org.example.tests;

import org.apache.commons.io.FileUtils;
import org.example.MyDriver;
import org.example.InfoReporter;
import org.example.models.User;
import org.example.pages.microsoft.MicrosoftSSOPage;
import org.example.pages.agreement.AgreementListPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Clase base para pruebas.
 */
public abstract class BaseTest extends InfoReporter {
    // Ruta relativa para el archivo de propiedades
    public static final String CONFIG_PROPERTIES = "src/test/java/org/example/resources/properties/config.properties";

    private User currentUser;

    private WebDriver driver;

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
            driver = MyDriver.getInstance(browser).getDriver(); // Utiliza el Singleton de MyDriver
            logInfo("Staring MainTask - HomePage");
            driver.manage().window().maximize();
            logInfo("Taking a screenshot: ");
            microsoftSSOPage = new MicrosoftSSOPage(driver, url);
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
        driver.quit();
    }

    public AgreementListPage getAgreementListPage() {
        return agreementListPage;
    }

}
