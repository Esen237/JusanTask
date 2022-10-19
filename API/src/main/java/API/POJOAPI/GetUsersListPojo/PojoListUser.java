package API.POJOAPI.GetUsersListPojo;


import API.APIHelpers.HelperMethods;
import API.POJOAPI.BaseForPojo;
import API.POJOAPI.URI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.Method;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoListUser extends BaseForPojo {


    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<DatumPojo> data;
    private SupportPojo support;


    public void getUsersList(String str) throws JsonProcessingException {
        PojoListUser pojoListUser = new PojoListUser();
        helperMethods.requestWithQueryParams(URI.LISTUSERS.endpoints, "page", "2", Method.GET);
        PojoListUser pojoListUser1 = sdConverter.deserialize(pojoListUser.helperMethods.requestWithQueryParams(URI.LISTUSERS.endpoints, "page", "2", Method.GET), PojoListUser.class);
        Assertions.assertTrue(pojoListUser1.getData().stream().allMatch(x -> x.getAvatar().contains(str)));

    }

    public void getUsersListWithPagination(String page) throws JsonProcessingException {
        Assertions.assertTrue(helperMethods.requestWithQueryParams(URI.LISTUSERS.endpoints, "page", page, Method.GET).contains("id"));

    }


    public void getUserListWithUnCorrectParam(int getPage , String page) throws JsonProcessingException {
        PojoListUser pojoListUser = new PojoListUser();
        helperMethods.requestWithQueryParams(URI.LISTUSERS.endpoints, "page", page, Method.GET);
        PojoListUser pojoListUser1 = sdConverter.deserialize(pojoListUser.helperMethods.requestWithQueryParams(URI.LISTUSERS.endpoints, "page", page, Method.GET), PojoListUser.class);
        Assertions.assertEquals(getPage, pojoListUser1.getPage());

    }

    public void getUserListWithError(int error) {
        Assertions.assertEquals(error, HelperMethods.preRequest("").request(Method.GET).getStatusCode());
    }


    public void getULWithNegativeOffSet(String page, int getPage) throws JsonProcessingException {
        PojoListUser pojoListUser2 = sdConverter.deserialize(helperMethods.requestWithQueryParams(URI.LISTUSERS.endpoints, "page", page, Method.GET), PojoListUser.class);
        Assertions.assertEquals(getPage, pojoListUser2.getData().get(0).getId());
    }

    public void getULWithNotExistOffSet(String page, String get) throws JsonProcessingException {
        PojoListUser pojoListUser3 = sdConverter.deserialize(helperMethods.requestWithQueryParams(URI.LISTUSERS.endpoints, "page", page, Method.GET), PojoListUser.class);
        Assertions.assertEquals(get, pojoListUser3.getData().toString());

    }


}
