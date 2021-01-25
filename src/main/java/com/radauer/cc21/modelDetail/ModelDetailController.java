package com.radauer.cc21.modelDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.radauer.cc21.shared.ConfigParams;

@RestController
public class ModelDetailController
{

    @Autowired
    private ModelDetailService modelDetailService;

    public ModelDetail getModelDetail(ConfigParams configParams){

        return modelDetailService.getModelDetail(configParams);
    }
}
