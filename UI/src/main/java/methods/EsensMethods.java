package methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class EsensMethods {


    public EsensMethods waitElementToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public EsensMethods waitElementToBeVisible(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public EsensMethods waitElementToBeClickableAndVisible(WebElement element) {
        waitElementToBeClickable(element).waitElementToBeVisible(element);
        return this;
    }

    public EsensMethods click(WebElement element) {
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public EsensMethods sendKeys(WebElement element, String str) {
       waitElementToBeVisible(element);
       element.sendKeys(str);
        return this;
    }

    public EsensMethods selectDropDownMenu(WebElement element, int number) {
        waitElementToBeVisible(element);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(number);
        return this;
    }
    public String getText(WebElement element){
        waitElementToBeVisible(element);
       return element.getText();
    }






}
