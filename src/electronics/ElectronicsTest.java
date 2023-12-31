package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.io.InterruptedIOException;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElements(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElements(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedIOException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElements(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElements(By.xpath(""));
        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expectedText, actualText);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //  Thread.sleep(2000);


        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020
        String expectedmsg = "Nokia Lumia 1020";
        String actualmsg = getTextFromElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals(expectedmsg, actualmsg);

        //2.7 Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));

        //2.8 Change quantity to 2
        WebElement Quantity = driver.findElement(By.id("//input[@id='product_enteredQuantity_20']"));

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@id='bar-notification']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElements(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("/button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        verifyText(By.xpath("//span[contains(text(),'Shopping cart')]") ,"SHOPPING CART ");
        //2.13 Verify the quantity is 2
        verifyText(By.xpath("//input[@id='itemquantity11222']"),"2");

        //2.14 Verify the Total $698.00
        verifyText(By.xpath("//tbody/tr[1]/td[6]/span[1]")," $698.00");

        //2.15 click on checkbox “I agree with the terms of service”
clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText(By.xpath(" //h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
verifyText(By.xpath("//h1[contains(text(),'Register')]"),"Register");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping card”
        verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //.27 Fill the Mandatory fields
        sendTextToElement(By.id("First name:"), "John");
        sendTextToElement(By.id("Last name:"), "Smith");
        sendTextToElement(By.id("Gender:"), "male");
        selectByValueFromDropDown(By.id("Date of birth:"),"15");
        selectByValueFromDropDown(By.id("Date of birth:"),"9");
        selectByValueFromDropDown(By.id("Date of birth:"),"1982");
        sendTextToElement(By.id("Email:"), "SmithJohn@hotmail.com");
        sendTextToElement(By.id("Password:"), "Smith12345@");
        sendTextToElement(By.id("Confirm password:"), "Smith12345@");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        //2.30 Click on “CONTINUE
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));


        //2.31 Select Radio Button “Credit Card"
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));


        //2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");


        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Jo Patel");
        sendTextToElement(By.id("CardNumber"), "4222222222222");
        selectByValueFromDropDown(By.id("ExpireMonth"), "7");
        selectByValueFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "135");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        // 2.36 Verify “Shipping Method” is “2nd Day Air”verifyText(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "2nd Day Air");

        //2.37 Verify Total is “$698.00”
        //verifyText(By.xpath("Vertfy 698 =//tbody/tr[1]/td[6]/span[1]"),"$698.00");

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));


        //2.39 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));


        //2.42 Verify the text “Welcome to our store”
        verifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");



        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));


        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Navigate sucessfully", baseUrl, currentUrl);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}


