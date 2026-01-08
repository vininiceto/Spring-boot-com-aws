package br.com.vininiceto.data.dto.v2;


import br.com.vininiceto.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTOV2 {



    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthDay;
    private String address;
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;


}