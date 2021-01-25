package com.radauer.cc21.config;

import java.util.List;

import com.radauer.cc21.eds.EdsResult;
import com.radauer.cc21.feasibility.FeasiblityResult;
import com.radauer.cc21.mathrix.Mathrix;
import com.radauer.cc21.modelData.ModelData;
import com.radauer.cc21.tecdata.TecData;

import lombok.Data;

@Data
public class ConfigData
{
    private ModelData modelData;
    private Mathrix mathrix;

    private String selectedExteriorCode;
    private String selectedInteriorCode;
    private List<String> selectedOptionCodes;

    private ModelDto model;
    private ExteriorDto selectedExterior;
    private InteriorDto selectedInterior;
    private List<OptionDto> selectedOptions;

    private List<ExteriorDto> availableExteriors;
    private List<InteriorDto> availableInteriors;
    private List<OptionDto> availableOptions;


    private EdsResult edsResult;
    private TecData tecData;
    private FeasiblityResult feasiblityResult;

}
