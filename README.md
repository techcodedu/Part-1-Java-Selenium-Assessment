# Java Selenium Web Comprehensive Assessment - Online Store

This assessment will test your understanding and practical skills in using Java with Selenium WebDriver. The topics covered include Locators and Weblements, Interacting with Webelemetns, Waits (implicit and explicit), and Alerts/Windows/Frames.

## Instructions

Please complete the following tasks using Java and Selenium WebDriver. Write clean, efficient, and well-documented code. Ensure you have the Selenium WebDriver and the necessary browser drivers installed.

We will use the "https://www.saucedemo.com/" website for this assessment.

### Locators and Weblements

1. Launch a browser of your choice and navigate to "https://www.saucedemo.com/".
2. Write a Java method that accepts a locator type (ID, Name, ClassName, TagName, CSS, XPath) and a locator value as parameters, and returns a WebElement.
3. Use the method created in (2) to find and print the following elements:
   - The logo with the class name "app_logo".
   - The username input field with the ID "user-name".
   - The password input field with the ID "password".
   - The login button with the class name "btn_action".

### Interacting with Webelemetns

1. Complete the following tasks using the WebElement instances found in the previous task:
   - Enter the text "standard_user" in the username input field.
   - Enter the text "secret_sauce" in the password input field.
   - Click the login button.
   - Verify that the user has successfully logged in by checking if an element with the class name "inventory_list" is present.

### Waits (implicit and explicit)

1. Implement an implicit wait of 10 seconds.
2. Write a method that accepts a WebDriverWait instance and a By instance as parameters, and returns a WebElement after waiting for it to be visible. Use this method to locate an element with the class name "inventory_list" and print its text.

### Alerts/Windows/Frames

1. Locate an element with the class name "inventory_item_name" and click it. Verify that an element with the class name "inventory_details_name" is present.
2. Click the button with the class name "btn_primary" to add the item to the cart. Verify that the cart icon shows "1".
3. Click the cart icon with the class name "shopping_cart_container" and verify that an element with the class name "cart_list" is present.

Once you have completed the assessment, review your code to ensure that it is properly formatted, documented, and adheres to best practices.
