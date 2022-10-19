package API.POJOAPI.Post;

import API.APIHelpers.HelperMethods;
import API.APIHelpers.SDConverter;
import API.POJOAPI.BaseForPojo;
import API.POJOAPI.URI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.Method;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUser extends BaseForPojo {
    private String email;
    private String password;
    private String error;


    public void registerUser(String password, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail("michael.lawson@reqres.in");
        registerUser.setPassword(password);
        String jSon = sdConverter1.serialize(registerUser);
        HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
    }

    public void registerUserWithUnCorrectData(String mail, String password, int code, String error) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(mail);
        registerUser.setPassword(password);
        String jSon = sdConverter1.serialize(registerUser);
        HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
        RegisterUser registerUser1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).asPrettyString(), RegisterUser.class);
        Assertions.assertEquals(error, registerUser1.getError());

    }

    public void registerUserWithNotValidData(String errorMassage,String password, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail("123");
        registerUser.setPassword(password);
        String jSon = sdConverter1.serialize(registerUser);
        HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
        RegisterUser registerUser1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).asPrettyString(), RegisterUser.class);
        Assertions.assertEquals(errorMassage, registerUser1.getError());

    }

    public void registerUserWithNotAllFields(int code,String error) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail("123");
        String jSon = sdConverter1.serialize(registerUser);
        HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
        RegisterUser registerUser1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).asPrettyString(), RegisterUser.class);
        Assertions.assertEquals(error, registerUser1.getError());

    }

    public void registerUserWithEmptyJSon(String error,int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        RegisterUser registerUser = new RegisterUser();
       String jSon = sdConverter1.serialize(registerUser);
        HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
        RegisterUser registerUser1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.REGISTER.endpoints, jSon, Method.POST).asPrettyString(), RegisterUser.class);
        Assertions.assertEquals(error,registerUser1.getError());


    }

}
