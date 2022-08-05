package com.helptek.spychobackend.utilities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ErrorMessage implements Serializable {

    String errorMessage ;
    Date timestamp ;
    String module;
    Long code ;
}
