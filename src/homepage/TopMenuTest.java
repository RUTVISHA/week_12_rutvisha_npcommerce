package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";
@Before
    public void  setup(){
        openBrowser(baseUrl);

}
@Test
    public void selectMenu(String menu) {
    String mainmenu = menu.toLowerCase();
    String expression = "//a[@href = '/" + menu + "']";
    driver.findElement(By.xpath(expression)).click();
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals("Navigate sucessfully", baseUrl + menu);

}

    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
