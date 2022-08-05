package com.helptek.spychobackend.model;

import com.helptek.spychobackend.utilities.enumerations.Sexe;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Personne implements Serializable {

    @Id
    @SequenceGenerator(name = "personne_seq", initialValue = 10000, sequenceName = "personne_seq" )
    @GeneratedValue(generator = "personne_seq")
    @Column(name = "id", unique = true, insertable = false)
    Long id ;

    @Column(nullable = false, length = 100, updatable = true)
    String nom ;

    @Column(nullable = false, length = 100, updatable = true)
    String prenom ;

    @Column(nullable = false, length = 100, updatable = true)
    @Enumerated(EnumType.STRING)
    Sexe sexe ;

    @Column(nullable = false,  updatable = true )
    Date date_naissance ;

    @Column(nullable = false, length = 20, updatable = true)
    String telephone ;

    String image ;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_compte" , insertable = true, unique = true)
    Compte compte ;

}
