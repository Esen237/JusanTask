package POM;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationForm extends BasePom {


    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement emailField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement genderMaleButton;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement mobileNumberField;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement dateOfBirthField;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElement yearSelector;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElement monthSelector;

    @FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--028 react-datepicker__day--selected']")
    WebElement daySelect;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement subjectField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicBoxField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingBoxField;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    WebElement pictureField;

    @FindBy(xpath = "//textarea[@placeholder='Current Address']")
    WebElement currentAddressField;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement stateSelect;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    WebElement citySelect;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//h5")
    WebElement studRegForm;


    public String getTextFromRegPage() {
        return esensMethods.getText(studRegForm);
    }

    public RegistrationForm inputFirstNameField(String str) {
        esensMethods.sendKeys(firstNameField, str);
        return this;
    }

    public RegistrationForm inputLastNameField(String str) {
        esensMethods.sendKeys(lastNameField, str);
        return this;
    }

    public RegistrationForm inputEmailField(String str) {
        esensMethods.sendKeys(emailField, str);
        return this;
    }

    public RegistrationForm pickGenderBox() {
        esensMethods.click(genderMaleButton);
        return this;
    }

    public RegistrationForm inputNumberField(long l) {
        esensMethods.sendKeys(mobileNumberField, String.valueOf(l));
        return this;
    }

    public RegistrationForm inputDateOfBirth() {
        esensMethods.click(dateOfBirthField).selectDropDownMenu(yearSelector, esensMockDataGenerator.GenerateNumberFrom1To33());
        esensMethods.selectDropDownMenu(monthSelector, esensMockDataGenerator.GenerateNumberFrom1To12());
        return this;
    }

    public RegistrationForm inputSubjectField() {
        esensMethods.click(mobileNumberField);
        esensMethods.sendKeys(subjectField, "s");
        subjectField.sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationForm clickBoxButtons() {
        esensMethods.click(musicBoxField);
        esensMethods.click(readingBoxField);
        return this;
    }

    public RegistrationForm selectPicture() {
        esensMethods.sendKeys(pictureField, "/Users/Esen/Desktop");
        return this;
    }

    public RegistrationForm inputCurrentAddressField(String str) {
        esensMethods.sendKeys(currentAddressField, str);
        return this;
    }

    public RegistrationForm selectState() {
        try {
            esensJavaScriptExecutor.jsClick(stateSelect);
            stateSelect.sendKeys(Keys.ARROW_DOWN);
            stateSelect.sendKeys(Keys.ENTER);
        }catch (Exception e){
            e.printStackTrace();
        }

        return this;
    }

    public RegistrationForm selectCity() {
        try {
            esensJavaScriptExecutor.jsClick(citySelect);
            citySelect.sendKeys(Keys.ARROW_DOWN);
            citySelect.sendKeys(Keys.ENTER);
        }catch (Exception e){
            e.printStackTrace();
        }

        return this;
    }

    public RegistrationForm clickSubmitButton() {
        esensJavaScriptExecutor.jsClick(submitButton);
        return this;
    }


}
