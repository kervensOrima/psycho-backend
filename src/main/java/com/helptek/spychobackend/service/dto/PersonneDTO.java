package com.helptek.spychobackend.service.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.helptek.spychobackend.utilities.enumerations.Sexe;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class PersonneDTO  implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id ;

    String nom ;

    String prenom ;

    @Enumerated(EnumType.STRING)
    Sexe sexe ;

    @JsonFormat(pattern="yyyy-MM-dd")
    Date date_naissance ;

    String telephone ;


    String image ;

    AccountDTO account;

}
