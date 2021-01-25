package com.radauer.cc21.shared;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfigChange
{
    private final ConfigChangeType type;
    private final String oldValue;
    private final String newValue;
}
