package com.helptek.spychobackend.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Publication")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class Publication implements Serializable {

    @Id
    @Column(name = "id_publication")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPublication ;

    LocalDateTime date_publication;
}
