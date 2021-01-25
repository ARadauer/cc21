package com.radauer.cc21.modelData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radauer.cc21.modelData.db.Nwtima;
import com.radauer.cc21.modelData.db.NwtimaRepository;
import com.radauer.cc21.modelData.db.Nwtimo;
import com.radauer.cc21.modelData.db.NwtimoRepository;

@Service
public class ModelDataService
{
    @Autowired
    private NwtimoRepository nwtimoRepository;
    @Autowired
    private NwtimaRepository nwtimaRepository;

    @Autowired
    private ModelDataMapper modelDataMapper;

    public ModelData getModelData(String modelCode)
    {
        Nwtimo nwtimo = nwtimoRepository.loadByModelCode(modelCode);
        List<Nwtima> nwtimaList = nwtimaRepository.loadByModelCode(modelCode);

        return ModelData.builder()
            .model(modelDataMapper.mapImoToModel(nwtimo))
            .optionList(modelDataMapper.mapImaToOptions(nwtimaList)).build();

    }
}
