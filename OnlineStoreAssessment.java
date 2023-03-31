import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OnlineStoreAssessment {

    private WebDriver driver;
    private WebDriverWait wait;

    public static void main(String[] args) {
        OnlineStoreAssessment assessment = new OnlineStoreAssessment();
        assessment.setUp();
        assessment.testLocatorsAndWebElements();
        assessment.testInteractingWithWebElements();
        assessment.testWaits();
        assessment.testAlertsWindowsFrames();
        assessment.tearDown();
    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, 10);
    }

    public void tearDown() {
        driver.quit();
    }

    public WebElement findElement(String locatorType, String locatorValue) {
        By by;
        switch (locatorType.toLowerCase()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "classname":
                by = By.className(locatorValue);
                break;
            case "tagname":
                by = By.tagName(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        return driver.findElement(by);
    }

    public void testLocatorsAndWebElements() {
        WebElement logo = findElement("classname", "login_logo");
        WebElement usernameInput = findElement("id", "user-name");
        WebElement passwordInput = findElement("id", "password");
        WebElement loginButton = findElement("id", "login-button");

        System.out.println("Logo: " + logo);
        System.out.println("Username input: " + usernameInput);
        System.out.println("Password input: " + passwordInput);
        System.out.println("Login button: " + loginButton);
    }

    public void testInteractingWithWebElements() {
        WebElement usernameInput = findElement("id", "user-name");
        WebElement passwordInput = findElement("id", "password");
        WebElement loginButton = findElement("id", "login-button");

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        WebElement inventoryList = findElement("classname", "inventory_list");
        System.out.println("Inventory List: " + inventoryList);
    }

    public WebElement waitUntilVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void testWaits() {
        WebElement inventoryList = waitUntilVisible(By.className("inventory_list"));
        System.out.println("Inventory List: " + inventoryList.getText());
    }

     public void testAlertsWindowsFrames() {
        WebElement itemName = findElement("classname", "inventory_item_name");
        itemName.click();

        WebElement inventoryDetailsName = findElement("classname", "inventory_details_name");
        System.out.println("Inventory Details Name: " + inventoryDetailsName.getText());

        WebElement addToCartButton = findElement("classname", "btn_primary");
        addToCartButton.click();

        WebElement cartBadge = findElement("classname", "shopping_cart_badge");
        System.out.println("Cart items: " + cartBadge.getText());
        assert cartBadge.getText().equals("1");

        WebElement cartIcon = findElement("id", "shopping_cart_container");
        cartIcon.click();

        WebElement cartList = findElement("classname", "cart_list");
        System.out.println("Cart List: " + cartList);
    }
}