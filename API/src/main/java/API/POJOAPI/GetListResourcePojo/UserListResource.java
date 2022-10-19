package API.POJOAPI.GetListResourcePojo;

import API.APIHelpers.HelperMethods;
import API.POJOAPI.BaseForPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.Method;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserListResource extends BaseForPojo {

    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<DatumListResource> data;
    public UserListResource support;


    private String getListResource(){
        return HelperMethods.preRequest("/u").request(Method.GET ).asPrettyString();

    }
    private String getSingleResource(String id){
        return HelperMethods.preRequest("/u/"+id).request(Method.GET ).asPrettyString();

    }


    public void GetSingleResNotFound(String ID) throws JsonProcessingException {
        UserListResource userListResource = new UserListResource();
        UserListResource userListResource1 = sdConverter.deserialize(userListResource.getSingleResource(ID), UserListResource.class);
        Assertions.assertNull(userListResource1.getData());
    }


    public void GetSingleResource(String ID, String get){
        UserListResource userListResource = new UserListResource();
        Assertions.assertTrue(userListResource.getSingleResource(ID).contains(get));
    }

    public void GetListResource(String get){
        UserListResource userListResource = new UserListResource();
        Assertions.assertTrue(userListResource.getListResource().contains(get));
    }



}
