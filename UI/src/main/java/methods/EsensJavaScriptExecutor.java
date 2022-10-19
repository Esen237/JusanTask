package methods;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class EsensJavaScriptExecutor {



    public EsensJavaScriptExecutor jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click",element);
        return this;
    }
    public EsensJavaScriptExecutor jsScrollToEnd(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        return this;
    }





}
