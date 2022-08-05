package com.helptek.spychobackend.service.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedecinDTO extends PersonneDTO implements Serializable {

    String specialite ;

    String experience ;

    String apropos ;

}
