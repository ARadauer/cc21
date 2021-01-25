package com.radauer.cc21.config;

import com.radauer.cc21.shared.Price;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModelDto
{
    private String code;
    private String name;

    private Price listPrice;
    private Price price;
}
