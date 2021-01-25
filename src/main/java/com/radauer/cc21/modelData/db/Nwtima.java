package com.radauer.cc21.modelData.db;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Nwtima
{
    private String code;
    private String name;
    private BigDecimal netPrice;
}
