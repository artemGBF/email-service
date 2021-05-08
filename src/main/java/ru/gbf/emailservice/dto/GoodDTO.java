package ru.gbf.emailservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodDTO implements Serializable {
    private Long id;
    private String name;
    private Integer price;
    private Long category;
}
