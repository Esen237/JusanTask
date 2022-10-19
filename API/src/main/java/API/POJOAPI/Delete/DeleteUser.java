package API.POJOAPI.Delete;

import API.APIHelpers.HelperMethods;
import API.APIHelpers.SDConverter;
import API.POJOAPI.BaseForPojo;
import API.POJOAPI.Post.CreateUser;
import API.POJOAPI.URI;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.Method;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class DeleteUser extends BaseForPojo {

    private int getStatusCode(String ID) {
        return HelperMethods.preRequest(URI.DELETE.endpoints + ID).request(Method.DELETE).getStatusCode();
    }

    public void deleteExistUser(String ID,int code) {
        MatcherAssert.assertThat(getStatusCode(ID), Matchers.is(code));

    }

    public void deletedUser(String ID,int code) {
        MatcherAssert.assertThat(getStatusCode(ID), Matchers.is(code));
    }

    public void deleteNoExistID(String ID,int code) {
        MatcherAssert.assertThat(getStatusCode(ID), Matchers.is(code));
    }

    public void deleteByNotValidID(String ID,int code) {
        MatcherAssert.assertThat(getStatusCode(ID), Matchers.is(code));

    }

    public void createAndDelete(String name, String job, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        String jSon = "";
        CreateUser createUser = new CreateUser();
        createUser.setName("esen");
        createUser.setJob("leader");
        jSon = sdConverter1.serialize(createUser);
        HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST);
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST).getStatusCode(), Matchers.is(201));
        CreateUser createUser1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.CREATE.endpoints, jSon, Method.POST).asPrettyString(), CreateUser.class);
        String ID = createUser1.getId();
        MatcherAssert.assertThat(getStatusCode(ID), Matchers.is(code));
    }
}



