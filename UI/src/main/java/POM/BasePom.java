package POM;

import UI.dataProviders.EsensMockDataGenerator;
import methods.EsensJavaScriptExecutor;
import methods.EsensMethods;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BasePom {
    public BasePom(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    EsensMockDataGenerator esensMockDataGenerator = new EsensMockDataGenerator();
    EsensMethods esensMethods = new EsensMethods();
    EsensJavaScriptExecutor esensJavaScriptExecutor = new EsensJavaScriptExecutor();

}
