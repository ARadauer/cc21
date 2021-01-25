package com.radauer.cc21.modelDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radauer.cc21.config.ConfigData;
import com.radauer.cc21.config.ConfigService;
import com.radauer.cc21.shared.ConfigParams;

@Service
public class ModelDetailService
{

    @Autowired
    private ConfigService configService;

    @Autowired
    private ModelDetailMapper modelDetailMapper;

    public ModelDetail getModelDetail(ConfigParams configParams)
    {
        ConfigData configData = configService.getConfigData(configParams);

        return modelDetailMapper.configDataToModelDetail(configData);
    }
}
