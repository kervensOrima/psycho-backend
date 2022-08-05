package com.helptek.spychobackend.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Compte")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Compte implements Serializable {
    @Id
    @Column(name = "id_compte", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    String email ;

    String password ;

    boolean is_active ;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "compte")
    Personne personne ;
}
