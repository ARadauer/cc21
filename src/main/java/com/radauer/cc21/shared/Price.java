package com.radauer.cc21.shared;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price
{
    private BigDecimal net;
    private BigDecimal gross;
}
