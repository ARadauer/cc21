package com.radauer.cc21.shared;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ConfigParams
{
    private String modelCode;
    private String exteriorCode;
    private String interiorCode;
    private String[] optionCodes;

    private List<ConfigChange> configChangeList;

}
