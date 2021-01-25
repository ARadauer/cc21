package com.radauer.cc21.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radauer.cc21.shared.ConfigParams;
import com.radauer.cc21.eds.EdsService;
import com.radauer.cc21.feasibility.FeasibilityService;
import com.radauer.cc21.mathrix.Mathrix;
import com.radauer.cc21.mathrix.PriceArticle;
import com.radauer.cc21.mathrix.PriceCalculation;
import com.radauer.cc21.mathrix.PriceGroup;
import com.radauer.cc21.modelData.Model;
import com.radauer.cc21.modelData.ModelData;
import com.radauer.cc21.modelData.ModelDataService;
import com.radauer.cc21.tecdata.TecDataService;

@Service
public class ConfigService
{
    @Autowired
    private ModelDataService modelDataService;

    @Autowired
    private TecDataService tecDataService;

    @Autowired
    private PriceCalculation priceCalculation;

    @Autowired
    private FeasibilityService feasibilityService;

    @Autowired
    private EdsService edsService;

    public ConfigData getConfigData(ConfigParams configParams)
    {
        ConfigData configData = new ConfigData();

        fillSelectionFromParams(configData, configParams);

        loadModelData(configData, configParams);

        checkFeasibility(configData);

        callEds(configData);

        calcPrices(configData);

        createTecData(configData);

        fillModelDto(configData);

        fillOptionDtos(configData);

        return configData;
    }

    private void fillOptionDtos(ConfigData configData)
    {
        Mathrix mathrix = configData.getMathrix();
        List<OptionDto> allOptions = configData.getModelData().getOptionList().stream()
            .map(option -> OptionDto.builder().code(option.getCode())
                .name(option.getName())
                .price(mathrix.get(PriceGroup.CUSTOMER, PriceArticle.OPTION, option.getCode()))
                .listPrice(mathrix.get(PriceGroup.LIST, PriceArticle.OPTION, option.getCode()))
                .build()).collect(Collectors.toList());

        configData.setAvailableOptions(allOptions);
        configData.setSelectedOptions(allOptions.stream()
            .filter(option -> configData.getSelectedOptionCodes()
                .contains(option.getCode())).collect(Collectors.toList()));
    }

    private void fillModelDto(ConfigData configData)
    {
        Model model = configData.getModelData().getModel();
        Mathrix mathrix = configData.getMathrix();

        ModelDto modelDto = ModelDto.builder()
            .code(model.getModelCode())
            .name(model.getName())
            .price(mathrix.get(PriceGroup.CUSTOMER, PriceArticle.MODEL))
            .listPrice(mathrix.get(PriceGroup.LIST, PriceArticle.MODEL))
            .build();

        configData.setModel(modelDto);
    }

    private void fillSelectionFromParams(ConfigData configData, ConfigParams configParams)
    {
        configData.setSelectedExteriorCode(configParams.getExteriorCode());
        configData.setSelectedInteriorCode(configParams.getInteriorCode());
        configData.setSelectedOptionCodes(Arrays.asList(configParams.getOptionCodes()));
    }

    private void loadModelData(ConfigData configData, ConfigParams configParams)
    {
        ModelData modelData = modelDataService.getModelData(configParams.getModelCode());
        configData.setModelData(modelData);
    }



    private void calcPrices(ConfigData configData)
    {
        Mathrix mathrix = priceCalculation.calculatePrices(configData);
        configData.setMathrix(mathrix);
    }

    private void createTecData(ConfigData configData)
    {
        configData.setTecData(tecDataService.createTecData(configData));
    }

    private void callEds(ConfigData configData)
    {
        configData.setEdsResult(edsService.callEdsService(configData));
    }

    private void checkFeasibility(ConfigData configData)
    {

        configData.setFeasiblityResult(feasibilityService.checkFeasibility(configData));
    }
}
