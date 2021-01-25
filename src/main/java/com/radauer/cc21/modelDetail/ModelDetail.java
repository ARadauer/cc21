package com.radauer.cc21.modelDetail;

import java.util.List;

import com.radauer.cc21.config.ExteriorDto;
import com.radauer.cc21.config.InteriorDto;
import com.radauer.cc21.config.ModelDto;
import com.radauer.cc21.config.OptionDto;
import com.radauer.cc21.eds.EdsResult;
import com.radauer.cc21.feasibility.FeasiblityResult;
import com.radauer.cc21.tecdata.TecData;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModelDetail
{

    private ModelDto model;
    private String selectedExteriorCode;
    private String selectedInteriorCode;
    private List<String> selectedOptionCodes;

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
