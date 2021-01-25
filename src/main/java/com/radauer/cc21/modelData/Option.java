package com.radauer.cc21.modelData;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Option
{
    private String code;
    private String name;
    private BigDecimal netPrice;
}
