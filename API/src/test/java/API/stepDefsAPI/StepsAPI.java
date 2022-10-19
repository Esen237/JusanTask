package API.stepDefsAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;

public class StepsAPI extends BaseAPI {


    @Given("Perform method GET to get list users that contains {string}")
    public void perform_method_get_to_get_list_users_that_contains(String string) throws JsonProcessingException {
        pojoListUser.getUsersList(string);
    }
    @Given("Perform method GET to get list users and choose page {string}")
    public void perform_method_get_to_get_list_users_and_choose_page(String string) throws JsonProcessingException {
        pojoListUser.getUsersListWithPagination(string);
    }
    @Given("Perform method GET to get list users choosing {string} page and should get {int} started id")
    public void performMethodGETToGetListUsersChoosingPageAndShouldGetStartedId(String arg0, int arg1) throws JsonProcessingException {
        pojoListUser.getULWithNegativeOffSet(arg0, arg1);
    }
    @Given("Perform method GET to get list users and choose page {string} and should get page {int}")
    public void perform_method_get_to_get_list_users_and_choose_page_and_should_get_page(String string, Integer int1) throws JsonProcessingException {
        pojoListUser.getUserListWithUnCorrectParam(int1, string);
    }
    @Given("Perform method GET to get list users with error and get {int}")
    public void perform_method_get_to_get_list_users_with_error_and_get(Integer int1) {
        pojoListUser.getUserListWithError(int1);
    }
    @Given("Perform method GET to get list users and choose page {string} and should get {string}")
    public void perform_method_get_to_get_list_users_and_choose_page_and_should_get(String string, String string2) throws JsonProcessingException {
        pojoListUser.getULWithNotExistOffSet(string, string2);
    }
    @Given("Perform method GET to get single user id {string} and get id {int} user")
    public void perform_method_get_to_get_single_user_id_and_get_id_user(String string, Integer int1) throws JsonProcessingException {
        userPojo.GetSingUser(string, int1);
    }
    @Given("Perform method GET to get single user id {string} and get nothing")
    public void perform_method_get_to_get_single_user_id_and_get_nothing(String string) throws JsonProcessingException {
        userPojo.GetSUByNotExistID(string);
    }
    @Given("Perform method GET to get single user not valid id {string} and get nothing")
    public void performMethodGETToGetSingleUserNotValidIdAndGetNothing(String arg0) throws JsonProcessingException {
        userPojo.GetSUByNotValidID(arg0);
    }
    @Given("Perform method GET to get single resource with not exist id {string}")
    public void performMethodGETToGetSingleResourceWithNotExistId(String arg0) throws JsonProcessingException {
        userListResource.GetSingleResNotFound(arg0);
    }
    @Given("Perform method GET to get single resource by id {string} and get {string}")
    public void performMethodGETToGetSingleResourceByIdAndGet(String arg0, String arg1) {
        userListResource.GetSingleResource(arg0, arg1);
    }
    @Given("Perform method GET to get List resource that contain {string}")
    public void performMethodGETToGetListResourceThatContain(String arg0) {
        userListResource.GetListResource(arg0);
    }
    @Given("Perform method PUT to update user by id {string}")
    public void performMethodPUTToUpdateUserById(String arg0) throws JsonProcessingException {
        putUpdate.updateWithNotAllFields(mockDataGenerators.nameGenerator(), arg0);
    }
    @Given("Perform method PUT to update users name and job than get {int} code")
    public void performMethodPUTToUpdateUsersNameAndJobThanGetCode(int arg0) throws JsonProcessingException {
        putUpdate.updateUser(mockDataGenerators.nameGenerator(), mockDataGenerators.jobGenerator(), arg0);
    }
    @Given("Perform method PUT to update users name and job than get {int} code using id {string}")
    public void performMethodPUTToUpdateUsersNameAndJobThanGetCodeUsingId(int arg0, String arg1) throws JsonProcessingException {
        putUpdate.updateWithNotExistID(arg1, mockDataGenerators.nameGenerator(), mockDataGenerators.jobGenerator(), arg0);
    }
    @Given("Perform method PUT to update users name and job than get {int} code using not valid id {string}")
    public void performMethodPUTToUpdateUsersNameAndJobThanGetCodeUsingNotValidId(int arg0, String arg1) throws JsonProcessingException {
        putUpdate.updateWithNotValidID(arg1, mockDataGenerators.nameGenerator(), mockDataGenerators.jobGenerator(), arg0);
    }
    @Given("Perform method POST to register user with not correct data and get code {int}, get massage {string}")
    public void performMethodPOSTToRegisterUserWithNotCorrectDataAndGetCodeGetMassage(int arg0, String arg1) throws JsonProcessingException {
        registerUser.registerUserWithUnCorrectData(mockDataGenerators.mailGenerator(), mockDataGenerators.passwordGenerator(), arg0, arg1);
    }
    @Given("Perform method POST to register user and get code {int}")
    public void performMethodPOSTToRegisterUserAndGetCode(int arg0) throws JsonProcessingException {
        registerUser.registerUser(mockDataGenerators.passwordGenerator(), arg0);
    }
    @Given("Perform method POST to register user using not valid data and get {int} code, get {string}")
    public void performMethodPOSTToRegisterUserUsingNotValidDataAndGetCodeGet(int arg0, String arg1) throws JsonProcessingException {
        registerUser.registerUserWithNotValidData(arg1, mockDataGenerators.passwordGenerator(), arg0);
    }
    @Given("Perform method POST to register user with no password field and get {int} code, get {string}")
    public void performMethodPOSTToRegisterUserWithNoPasswordFieldAndGetCodeGet(int arg0, String arg1) throws JsonProcessingException {
        registerUser.registerUserWithNotAllFields(arg0, arg1);
    }
    @Given("Perform method POST to register user with empty JSon and get {int} code, get {string}")
    public void performMethodPOSTToRegisterUserWithEmptyJSonAndGetCodeGet(int arg0, String arg1) throws JsonProcessingException {
        registerUser.registerUserWithEmptyJSon(arg1, arg0);
    }
    @Given("Perform method POST to create user and get {int} code")
    public void performMethodPOSTToCreateUserAndGetCode(int arg0) throws JsonProcessingException {
        createUser.createUser(mockDataGenerators.nameGenerator(), mockDataGenerators.jobGenerator(), arg0);
    }
    @Given("Perform method POST to create user with not all field and get {int} code")
    public void performMethodPOSTToCreateUserWithNotAllFieldAndGetCode(int arg0) throws JsonProcessingException {
        createUser.createUserNotAllFields(mockDataGenerators.nameGenerator(), arg0);
    }
    @Given("Perform method POST to create user with no fields and get {int} code")
    public void performMethodPOSTToCreateUserWithNoFieldsAndGetCode(int arg0) throws JsonProcessingException {
        createUser.createUserNoOneField(arg0);
    }
    @Given("Perform method POST to create user with empty body and get {int} code")
    public void performMethodPOSTToCreateUserWithEmptyBodyAndGetCode(int arg0) throws JsonProcessingException {
        createUser.createUserWithEmptyBody(arg0);
    }
    @Given("Perform method POST to create user to get time")
    public void performMethodPOSTToCreateUserToGetTime() throws JsonProcessingException {
        createUser.createUserGetData(mockDataGenerators.nameGenerator(), mockDataGenerators.jobGenerator());
    }
    @Given("Perform method DELETE to delete user id {string} and get {int} code")
    public void performMethodDELETEToDeleteUserIdAndGetCode(String arg0, int arg1) {
        deleteUser.deletedUser(arg0,arg1);
    }


    @Given("Perform method DELETE to delete exist user id {string} and get {int} code")
    public void performMethodDELETEToDeleteExistUserIdAndGetCode(String arg0, int arg1) {
        deleteUser.deleteExistUser(arg0,arg1);
    }


    @Given("Perform method DELETE to delete no exist user id {string} and get {int} code")
    public void performMethodDELETEToDeleteNoExistUserIdAndGetCode(String arg0, int arg1) {
        deleteUser.deleteNoExistID(arg0,arg1);
    }

    @Given("Perform method DELETE to delete not valid  user id {string} and get {int} code")
    public void performMethodDELETEToDeleteNotValidUserIdAndGetCode(String arg0, int arg1) {
        deleteUser.deleteByNotValidID(arg0,arg1);
    }

    @Given("Perform method DELETE to create and delete user and get {int} code")
    public void performMethodDELETEToCreateAndDeleteUserAndGetCode(int arg0) throws JsonProcessingException {
        deleteUser.createAndDelete(mockDataGenerators.nameGenerator(), mockDataGenerators.jobGenerator(), arg0);
    }
}




