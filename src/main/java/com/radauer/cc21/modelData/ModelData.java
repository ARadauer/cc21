package com.radauer.cc21.modelData;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModelData
{
    private Model model;
    private List<Option> optionList;
}
