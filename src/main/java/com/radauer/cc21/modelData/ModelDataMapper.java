package com.radauer.cc21.modelData;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.radauer.cc21.modelData.db.Nwtima;
import com.radauer.cc21.modelData.db.Nwtimo;

@Service
public class ModelDataMapper
{
    public Model mapImoToModel(Nwtimo nwtimo)
    {
        return Model.builder()
            .modelCode(nwtimo.getModelCode())
            .name(nwtimo.getModelCode()).build();
    }

    public List<Option> mapImaToOptions(List<Nwtima> nwtimaList)
    {
        return nwtimaList.stream().map(this::mapImaToOption).collect(Collectors.toList());
    }

    public Option mapImaToOption(Nwtima nwtima)
    {
        return Option.builder()
            .code(nwtima.getCode())
            .name(nwtima.getName())
            .netPrice(nwtima.getNetPrice())
            .build();
    }
}
