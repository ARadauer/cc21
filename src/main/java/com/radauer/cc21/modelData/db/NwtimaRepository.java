package com.radauer.cc21.modelData.db;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class NwtimaRepository
{
    public List<Nwtima> loadByModelCode(String modelCode)
    {
        return Arrays.asList(
            Nwtima.builder().code("PH1").name("Klima von " + modelCode).netPrice(new BigDecimal("123")).build(),
            Nwtima.builder().code("XXX").name("Sitze von " + modelCode).netPrice(new BigDecimal("123")).build()
        );
    }
}
