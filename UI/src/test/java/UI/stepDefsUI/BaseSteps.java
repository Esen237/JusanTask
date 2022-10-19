package UI.stepDefsUI;

import POM.RegistrationForm;
import UI.dataProviders.EsensMockDataGenerator;
import methods.EsensJavaScriptExecutor;

public class BaseSteps {
    RegistrationForm registrationForm = new RegistrationForm();
    EsensMockDataGenerator esensMockDataGenerator = new EsensMockDataGenerator();
    EsensJavaScriptExecutor esensJavaScriptExecutor = new EsensJavaScriptExecutor();
}
