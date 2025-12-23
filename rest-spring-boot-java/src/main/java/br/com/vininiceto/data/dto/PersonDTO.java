package br.com.vininiceto.data.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String gender;


}