package com.bgaray.utils.tests;

import com.bgaray.utils.screens.BottomMenu;
import com.bgaray.Screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();
    public static AndroidDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp(){
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }
        catch(MalformedURLException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void loadProperties(){
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }
        catch (IOException e){
            throw new RuntimeException("Error" + PROPERTIES_FILE);
        }
    }

    public static void setUpCapabilities(UiAutomator2Options capabilities) {
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setPlatformName(getCapability("deviceName"));
        capabilities.setPlatformName(getCapability("appPackage"));
        capabilities.setPlatformName(getCapability("appActivity"));
    }

    public static String getCapability(String variable){
        return properties.getProperty(variable);
    }

    public BottomMenu returBottomMenu() { return new BottomMenu(driver); }
    public HomeScreen returnHomeScreen(){
        return new HomeScreen(driver);
    }
    public SignUpScreen returnSignUpScreen(){
        return new SignUpScreen(driver);
    }
    public LogInScreen returnLogInScreen(){
        return new LogInScreen(driver);
    }
    public FormsScreen returnFormsScreen(){
        return new FormsScreen(driver);
    }
    public SwipeScreen returnSwipeScreen(){
        return new SwipeScreen(driver);
    }
    public WebviewScreen returnWebviewScreen() { return new WebviewScreen(driver); }
    public DragScreen returnDragScreen() { return new DragScreen(driver); }

}
