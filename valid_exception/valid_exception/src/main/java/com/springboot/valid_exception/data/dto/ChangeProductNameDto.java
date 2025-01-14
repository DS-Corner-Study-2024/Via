package com.springboot.valid_exception.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeProductNameDto {
    private Long number;
    private String name;
}