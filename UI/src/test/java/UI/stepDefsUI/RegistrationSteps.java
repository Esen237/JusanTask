package UI.stepDefsUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import utils.Driver;

public class RegistrationSteps extends BaseSteps{
    String lastName = esensMockDataGenerator.lastNameGenerator();
    String firstName = esensMockDataGenerator.firstNameGenerator();
    String mail = esensMockDataGenerator.emailGenerator();
    String textAddress = esensMockDataGenerator.textGenerate();
    long number = esensMockDataGenerator.numberGenerate();

    @Given("User on {string}")
    public void user_on(String string) {
        Driver.getDriver().get(string);

    }
    @And("User should see the text{string}")
    public void userShouldSeeTheText(String arg0) {
       assertEquals(arg0,registrationForm.getTextFromRegPage());
    }
    @Given("User fill all fields using mock data")
    public void user_fill_all_fields_using_mock_data() {
        registrationForm.inputFirstNameField(firstName);
        registrationForm.inputLastNameField(lastName);
        registrationForm.inputEmailField(mail);
        registrationForm.pickGenderBox();
        registrationForm.inputNumberField(number);
        registrationForm.inputDateOfBirth();
        esensJavaScriptExecutor.jsScrollToEnd();
        registrationForm.inputSubjectField();
        registrationForm.clickBoxButtons();
        registrationForm.selectPicture();
        registrationForm.inputCurrentAddressField(textAddress);
        registrationForm.selectState();
        registrationForm.selectCity();
    }
    @Then("User click on submit button")
    public void user_click_on_submit_button() {
        registrationForm.clickSubmitButton();
        Driver.closeDriver();

    }


}
