package API.APIHelpers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class SDConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public   <T> T deserialize(String json, Class<T> classes ) throws JsonProcessingException {
        return objectMapper.readValue(json, classes);
    }
    public   <T> String serialize(T tClass) throws JsonProcessingException {
        return objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).writeValueAsString(tClass);
//        return objectMapper.writeValueAsString(tClass);
    }


}
