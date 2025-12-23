package br.com.vininiceto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "First Name not be a null")
    private String firstName;
    @NotNull(message = "Last Name not be a null")
    private String lastName;
    @NotNull(message = "Adress not be a null")
    private String adress;
    @Length(min = 1, max = 6)
    private String gender;

    public String getAddress() {
        return adress;
    }

}