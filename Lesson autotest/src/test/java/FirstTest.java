import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class FirstTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpProperty()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Инициализация драйверa
    }

    @BeforeMethod
    public void configDriver()
    {
        driver = new ChromeDriver();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    @Test
    public void fastTest()
    {
        driver.get("https://touch.com.ua/item/smartfon-apple-iphone-13-pro-max-128gb-sierra-blue/"); // открывает страницу

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement iphoneColorButton = driver.findElement(By.xpath("//a[@title='seryy']"));
        scrollToElement(iphoneColorButton); // Scroling until element (JS)
        iphoneColorButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        scrollToElement(searchField);

        String iPhone = "iPhone";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        searchField.sendKeys(iPhone);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> iPhoneSearchList = driver.findElements(By.xpath("//div[@class='item product sku']"));
        for(WebElement element: iPhoneSearchList)
        {
            assertTrue(element.getText().contains(iPhone));
        }
    }

    @Test
    public void testMainPageTouch()
    {
        driver.get("https://touch.com.ua/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String pageUrl = driver.getCurrentUrl();
        assertEquals(pageUrl, "https://touch.com.ua/");
    }

    @Test
    public void testSearch()
    {
        driver.get("https://touch.com.ua/");
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));

        String searchInput = "Xiaomi";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        searchField.sendKeys(searchInput);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> XiaomiSearchList = driver.findElements(By.xpath("//div[@class='item product sku']"));
        for(WebElement element: XiaomiSearchList)
        {
            assertTrue(element.getText().contains(searchInput));
        }
    }

    @Test
    public void appleProduction()
    {
        driver.get("https://touch.com.ua/");
        WebElement appleProductionButton = driver.findElement(By.xpath("//ul[@class='footerMenu']/li[1]/a[@href='/tekhnika-apple/']"));
        scrollToElement(appleProductionButton);
        appleProductionButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String pageUrl = driver.getCurrentUrl();
        assertEquals(pageUrl, "https://touch.com.ua/tekhnika-apple/");
    }

    @Test
    public void xiaomiMostExpensiveKickScooter()
    {
        driver.get("https://touch.com.ua/");
        driver.manage().window().maximize();
        WebElement xiaomiProductionButton = driver.findElement(By.xpath("//ul[@class='footerMenu']/li[2]/a[@href='/tekhnika-xiaomi/']"));
        scrollToElement(xiaomiProductionButton);
        xiaomiProductionButton.click();

        String pageUrl = driver.getCurrentUrl();
        assertEquals(pageUrl, "https://touch.com.ua/tekhnika-xiaomi/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement filterPrice = driver.findElement(By.xpath("//span[@class='sort_item'][3]"));
        scrollToElement(filterPrice);
        filterPrice.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement filterOpenAll = driver.findElement(By.xpath("(//a[@class='showALL'])[1]"));
        scrollToElement(filterOpenAll);
        filterOpenAll.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement filterCategory = driver.findElement(By.xpath("//label[@for='arrFilter_93_2657910981']"));
        scrollToElement(filterCategory);
        filterCategory.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement showMoreButton = driver.findElement(By.xpath("//a[@class='showMore']"));
        scrollToElement(showMoreButton);
        showMoreButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String categoryName = "Электросамокат Xiaomi";
        List<WebElement> XiaomiCategoryList = driver.findElements(By.xpath("//div[@class='item product sku']"));
        for(WebElement element: XiaomiCategoryList)
        {
            assertTrue(element.getText().contains(categoryName));
        }

        int maxPrice=0;
        String tmp = null;
        int tmp1;

        List<WebElement> priceList = driver.findElements(By.xpath("//a[@class='price']/div[2]"));
        for (WebElement element: priceList)
        {
            tmp = element.getText();
            tmp = tmp.replace("₴","");
            tmp = tmp.replace(" ","");
            tmp1 = Integer.parseInt(tmp);
            if (tmp1 > maxPrice)
            {
                maxPrice = tmp1;
            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement mostExpensive = driver.findElement(By.xpath("//div[@id='bx_3966226736_40130']"));
        scrollToElement(mostExpensive);
        mostExpensive.click();

        WebElement maxPriceOfCurrentGood = driver.findElement(By.xpath("//*[@id=\"elementTools\"]/div/div[1]/div[2]/div[1]/a"));
        String tmp2 = maxPriceOfCurrentGood.getText();
        tmp2 = tmp2.replace("₴","");
        tmp2 = tmp2.replace(" ","");
        int tmp3 = Integer.parseInt(tmp2);
        assertEquals(maxPrice,tmp3);


    }

    @Test
    public void cheapestMarkdowniPhone()
    {
        driver.get("https://touch.com.ua/");
        driver.manage().window().maximize();
        WebElement markdownPage = driver.findElement(By.xpath("//ul[@class='footerMenu']/li[15]/a[@href='/utsenka-i-b-u/']"));
        scrollToElement(markdownPage);
        markdownPage.click();

        String pageUrl = driver.getCurrentUrl();
        assertEquals(pageUrl, "https://touch.com.ua/utsenka-i-b-u/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement filterPrice = driver.findElement(By.xpath("//span[@class='sort_item'][2]"));
        scrollToElement(filterPrice);
        filterPrice.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement categorySmartphone = driver.findElement(By.xpath("//label[@for='arrFilter_93_4057368544']"));
        scrollToElement(categorySmartphone);
        categorySmartphone.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement filterApple = driver.findElement(By.xpath("//label[@for='arrFilter_100_2212294583']"));
        scrollToElement(filterApple);
        filterApple.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addMore = driver.findElement(By.xpath("//div[@id='btn_0fc02108edfd553ef56d51e927d7190d']"));
        scrollToElement(addMore);
        addMore.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String markdown = "Смартфон Apple";
        List<WebElement> markdownList = driver.findElements(By.xpath("//div[@class='item product sku']"));
        for(WebElement element: markdownList)
        {
            assertTrue(element.getText().contains(markdown));
        }

        WebElement mostCheap = driver.findElement(By.xpath("//div[@id='bx_3966226736_53713']"));
        scrollToElement(mostCheap);
        mostCheap.click();

    }

    @Test
    public void wholeSmartphonesAppleCount()
    {
        driver.get("https://touch.com.ua/");
        driver.manage().window().maximize();

        WebElement appleProductionButton = driver.findElement(By.xpath("//ul[@class='footerMenu']/li[1]/a[@href='/tekhnika-apple/']"));
        scrollToElement(appleProductionButton);
        appleProductionButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String pageUrl = driver.getCurrentUrl();
        assertEquals(pageUrl, "https://touch.com.ua/tekhnika-apple/");

        WebElement iphone = driver.findElement(By.xpath("//div[@class='catalog-section-list-item'][4]"));
        scrollToElement(iphone);
        iphone.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String pageUrl1 = driver.getCurrentUrl();
        assertEquals(pageUrl1, "https://touch.com.ua/Telefony-iPhone/");
    }


    //@AfterMethod
    //public void tearDown()
    //{
        //driver.quit();
    //}
}