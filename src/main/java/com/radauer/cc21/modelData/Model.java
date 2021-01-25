package com.radauer.cc21.modelData;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Model
{
    String modelCode;
    String name;
}
