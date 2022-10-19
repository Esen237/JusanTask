package API.POJOAPI.GetListResourcePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatumListResource {
    public int id;
    public String name;
    public int year;
    public String color;
    public String pantone_value;
}
