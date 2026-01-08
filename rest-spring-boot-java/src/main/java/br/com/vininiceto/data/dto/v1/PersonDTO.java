package br.com.vininiceto.data.dto.v1;


/*import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;*/

import br.com.vininiceto.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

//@JsonPropertyOrder({"id", "adress", "first_name", "last_name", "gender"})
public class PersonDTO {

    @JsonView(Views.Public.class)
    private Long id;
    //  @JsonProperty("first_name")
    @JsonView(Views.Public.class)
    private String firstName;
    //@JsonProperty("last_name")
    @JsonView(Views.Public.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;
    @JsonView(Views.Public.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;
    @JsonView(Views.Public.class)
    private String address;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonView(Views.Public.class)
    private String phoneNumber;
    @JsonView(Views.Public.class)
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;
    @JsonView(Views.Internal.class)
    private String sensitiveData;


}