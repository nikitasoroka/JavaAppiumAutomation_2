import  io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest{

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\User\\JavaAppiumAutomation_2\\apks\\wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

//    @Test
//    public void firstTest()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Skip')]"),
//                "Cannot find Skip button",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search input",
//                10
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search input",
//                10
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Java",
//                "Cannot input the text",
//                20
//        );
//
//        waitForElementPresent(
//                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//        );
//    }

    @Test
    public void swipeArticle()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find Skip button",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@class='android.widget.EditText']//*[@text='Search Wikipedia']"),
                "Cannot find the search field",
                10);

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                10
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot input the text",
                20
        );

        waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot open the 'Object-oriented programming language' topic searching by 'Java' link",
                15
        );

        waitForElementPresent(
                By.xpath("//android.view.View[@content-desc=\"Java (programming language)\"]"),
                "Cannot find the opened page",
                15
                );

//        swipeUp(2000);
//        swipeUp(2000);
//        swipeUp(2000);
//        swipeUp(2000);
//        swipeUp(2000);

    }

//    @Test
//    public void searchAndClear() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Skip')]"),
//                "Cannot find Skip button",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search input",
//                15
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Java",
//                "Cannot input the text",
//                20
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Java')]"),
//                "Cannot find search input",
//                15
//        );
//
//        waitForElementAndClear(
//                By.xpath("//*[contains(@text,'Java')]"),
//                "Cannot find search input",
//                10
//        );
//    }
//    @Test
//
//    public void testCompareArticleTitle()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Skip')]"),
//                "Cannot find Skip button",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Java",
//                "Cannot input the text",
//                30
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
//                "Cannot open the 'Java' link",
//                30
//        );
//
//        waitForElementPresent(
//                By.xpath(),
//                "Cannot find article title",
//                15
//
//        );
//    }

//    @Test
//
//    public void testCancelSearch()
//    {
//        waitForElementAndClick(
//                By.id("//*[contains(@text,'Skip')]"),
//                "Cannot find Skip button",
//                5
//        );
//
//        waitForElementAndClick(
//                By.id("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Appium",
//                "Cannot input the text",
//                10
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Close button doesn't work",
//                5
//        );
//
//        waitForElementNotPresent(
//                By.id("rg.wikipedia:id/search_close_btn"),
//                "X is still presented on the page",
//                5
//        );
//    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message){
            return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }}

//    protected void swipeUp (int timeOfSwipe)
//    {
//        TouchAction action = new TouchAction(driver);
//        Dimension size = driver.manage().window().getSize();
//        int x = size.width / 2;
//        int start_y = (int) (size.height * 0.8);
//        int end_y = (int) (size.height * 0.2);
//
//        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).perform();
//    }
//}

//    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)   // метод который показывает, что мы ожидаем, что элемента "X" больше не будет на странице
//    {
//     WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//     wait.withMessage(error_message + "\n");
//     return wait.until(
//             ExpectedConditions.invisibilityOfElementLocated(by)
//     );
//    }

//    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
//    {
//        WebElement element = waitForElementAndClear(by, error_message, timeoutInSeconds);
//        element.clear();
//        return element;
//    }
//}
