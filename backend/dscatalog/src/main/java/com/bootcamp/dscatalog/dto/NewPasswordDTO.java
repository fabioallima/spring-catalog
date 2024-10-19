package com.bootcamp.dscatalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.beans.ConstructorProperties;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewPasswordDTO {

    @NotBlank(message = "Campo Obrigatório")
    private String token;

    @NotBlank(message = "Campo Obrigatório")
    @Size(min = 8, message = "Deve ter no mínimo 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$", message = "Senha Fraca")
    private String password;

}
