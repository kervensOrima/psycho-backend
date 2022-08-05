package com.helptek.spychobackend.service.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
}
