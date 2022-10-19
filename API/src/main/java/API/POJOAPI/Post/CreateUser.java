package API.POJOAPI.Post;

import API.APIHelpers.SDConverter;
import API.APIHelpers.HelperMethods;
import API.POJOAPI.BaseForPojo;
import API.POJOAPI.URI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.Method;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUser extends BaseForPojo {
    private String name;
    private String job;
    private String id;
    private Date createdAt;


    public void createUser(String name, String job, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        CreateUser createUser = new CreateUser();
        createUser.setName(name);
        createUser.setJob(job);
        String jSon = sdConverter1.serialize(createUser);
        HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
    }

    public void createUserNotAllFields(String name, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        CreateUser createUser = new CreateUser();
        createUser.setName(name);
        String jSon = sdConverter1.serialize(createUser);
        HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
    }

    public void createUserNoOneField(int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        CreateUser createUser = new CreateUser();
        createUser.setName("");
        createUser.setJob("");
        String jSon = sdConverter1.serialize(createUser);
        HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
    }

    public void createUserWithEmptyBody(int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        CreateUser createUser = new CreateUser();
        String jSon = sdConverter1.serialize(createUser);
        HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(code));
    }

    public void createUserGetData(String name, String job) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        CreateUser createUser = new CreateUser();
        createUser.setName(name);
        createUser.setJob(job);
        String jSon = sdConverter1.serialize(createUser);
        CreateUser createUser1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST).asPrettyString(), CreateUser.class);
        System.out.println(createUser1.getCreatedAt());

    }


}
