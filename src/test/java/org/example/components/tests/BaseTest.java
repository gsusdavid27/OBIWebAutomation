package org.example.components.tests;

import org.example.components.MyDriver;
import org.example.InfoReporter;
import org.example.components.model.entity.User;
import org.example.components.pages.microsoft.MicrosoftSignInPage;
import org.example.components.pages.agreement.AgreementListPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * BaseTest serves as the base test class for other test classes.
 */
public abstract class BaseTest extends InfoReporter {
    public static final String CONFIG_PROPERTIES = "src/test/resources/config.properties";
    public User currentUser;
    public String url;
    private String browser;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "environment"})
    public void beforeSuite(String browser, String environment) {
        this.browser=browser;
        try {
            initializeEnvironmentProperties(environment);
            initializeDriver(browser);
        } catch (IOException e) {
            logError("Failed to read Environment Properties");
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        closeDriver();
    }


    private void initializeEnvironmentProperties(String environment) throws IOException {
        logInfo("### Reading Environment Properties File ###");
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Path.of(CONFIG_PROPERTIES)));
        url = properties.getProperty(environment + ".url");
        String username = properties.getProperty(environment + ".username");
        String password = properties.getProperty(environment + ".password");
        currentUser = new User(username, password);
        logInfo("Browser: " + browser);
    }

    private void initializeDriver(String browser) {
        MyDriver md = MyDriver.getInstance(browser);
        WebDriver driver = md.getDriver();
        driver.manage().window().maximize();
        logInfo("Starting MainTask - HomePage");
    }

    private void closeDriver() {
        MyDriver.getInstance("").closeDriver();
    }

}
