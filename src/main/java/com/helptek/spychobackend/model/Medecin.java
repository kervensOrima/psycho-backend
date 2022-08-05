package com.helptek.spychobackend.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "Medecin")

@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medecin extends Personne implements Serializable {

    @Column(name = "specialite_medecin", length = 50 , nullable = false)
    String specialite ;

    @Column(name = "experience", length = 50 , nullable = false)
    String experience ;

    @Column(name = "apropos", length = 255 , nullable = false)
    String apropos ;

}
