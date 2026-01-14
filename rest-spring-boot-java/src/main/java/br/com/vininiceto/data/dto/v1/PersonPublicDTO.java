package br.com.vininiceto.data.dto.v1;

import br.com.vininiceto.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonPublicDTO extends RepresentationModel<PersonPublicDTO> {

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
}
