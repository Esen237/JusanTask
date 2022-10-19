package API.POJOAPI.GetUserPojo;


import API.APIHelpers.HelperMethods;
import API.POJOAPI.BaseForPojo;
import API.POJOAPI.URI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.Method;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo extends BaseForPojo {
    private DataUser data;
    private SupportPojo support;


    private String getSingleUser(String id){
        return HelperMethods.preRequest((URI.SINGLEUSER.endpoints) + id).request(Method.GET ).asPrettyString();
    }

    public void GetSingUser(String ID, int expect) throws JsonProcessingException {
        UserPojo userPojo = new UserPojo();
        UserPojo userPojo1 = sdConverter.deserialize(userPojo.getSingleUser(ID), UserPojo.class);
        Assertions.assertEquals(2, userPojo1.getData().getId());
    }

    public void GetSUByNotValidID(String ID) throws JsonProcessingException {
        UserPojo userPojo = new UserPojo();
        UserPojo userPojo1 = sdConverter.deserialize(userPojo.getSingleUser(ID), UserPojo.class);
        Assertions.assertNull(userPojo1.getData());
    }
    public void GetSUByNotExistID(String ID) throws JsonProcessingException {
        UserPojo userPojo = new UserPojo();
        UserPojo userPojo1 = sdConverter.deserialize(userPojo.getSingleUser(ID), UserPojo.class);
        Assertions.assertNull(userPojo1.getData());
    }







}
