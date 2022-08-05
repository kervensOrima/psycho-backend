package com.helptek.spychobackend.service.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AccountDTO implements Serializable {

    Long idAccount ;


    @Email(message = "L'adresse email est invalide!")
    String email ;
}
