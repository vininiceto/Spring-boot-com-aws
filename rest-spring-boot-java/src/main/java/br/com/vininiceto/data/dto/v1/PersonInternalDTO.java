package br.com.vininiceto.data.dto.v1;


/*import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;*/

import br.com.vininiceto.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

//@JsonPropertyOrder({"id", "adress", "first_name", "last_name", "gender"})
public class PersonInternalDTO extends RepresentationModel<PersonInternalDTO> {

    private Long id;
    //  @JsonProperty("first_name")
    private String firstName;
    //@JsonProperty("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;
    private String address;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phoneNumber;
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;
    private String sensitiveData;





}
