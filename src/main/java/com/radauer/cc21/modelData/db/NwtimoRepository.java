package com.radauer.cc21.modelData.db;

import org.springframework.stereotype.Repository;

@Repository
public class NwtimoRepository
{
    public Nwtimo loadByModelCode(String modelCode)
    {
        return Nwtimo.builder().modelCode(modelCode).modelName("Name of " + modelCode).build();
    }
}
