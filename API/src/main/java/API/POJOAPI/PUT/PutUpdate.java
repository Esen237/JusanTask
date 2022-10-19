package API.POJOAPI.PUT;

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
public class PutUpdate extends BaseForPojo {

    private String name;
    private String job;


    public void updateUser(String name, String job, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        String jSon = "";
        PutUpdate putUpdate = new PutUpdate();
        putUpdate.setName(name);
        putUpdate.setJob(job);
        jSon = sdConverter1.serialize(putUpdate);
    PutUpdate putUpdate1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.UPDATE.endpoints + "2", jSon, Method.PUT).asPrettyString(), PutUpdate.class);
    Assertions.assertEquals(name,putUpdate1.getName());
    MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.UPDATE.endpoints+"2", jSon, Method.PUT).getStatusCode(), Matchers.is(code));
    }


    public void updateWithNotExistID(String ID,String name, String job, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        String jSon = "";
        PutUpdate putUpdate = new PutUpdate();
        putUpdate.setName(name);
        putUpdate.setJob(job);
        jSon = sdConverter1.serialize(putUpdate);
        PutUpdate putUpdate1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.UPDATE.endpoints + ID, jSon, Method.PUT).asPrettyString(), PutUpdate.class);
        Assertions.assertEquals(name,putUpdate1.getName());
        Assertions.assertEquals(job,putUpdate1.getJob());
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.UPDATE.endpoints+"90", jSon, Method.PUT).getStatusCode(), Matchers.is(code));
    }


    public void updateWithNotValidID(String ID,String name, String job, int code) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        String jSon = "";
        PutUpdate putUpdate = new PutUpdate();
        putUpdate.setName(name);
        putUpdate.setJob(job);
        jSon = sdConverter1.serialize(putUpdate);
        PutUpdate putUpdate1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.UPDATE.endpoints + ID, jSon, Method.PUT).asPrettyString(), PutUpdate.class);
        Assertions.assertEquals(name,putUpdate1.getName());
        Assertions.assertEquals(job,putUpdate1.getJob());
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.UPDATE.endpoints+ID, jSon, Method.PUT).getStatusCode(), Matchers.is(code));
    }

    public void updateWithNotAllFields(String name,String ID) throws JsonProcessingException {
        SDConverter sdConverter1 = new SDConverter();
        String jSon = "";
        PutUpdate putUpdate = new PutUpdate();
        putUpdate.setName(name);
        jSon = sdConverter1.serialize(putUpdate);
        PutUpdate putUpdate1 = sdConverter.deserialize(HelperMethods.requestWithBody(URI.UPDATE.endpoints +ID, jSon, Method.PUT).asPrettyString(), PutUpdate.class);
        Assertions.assertEquals(name,putUpdate1.getName());
        MatcherAssert.assertThat(HelperMethods.requestWithBody(URI.UPDATE.endpoints+ID, jSon, Method.PUT).getStatusCode(), Matchers.is(200));
    }



    }

