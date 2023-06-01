package com.apple.io.dto.mpesa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemItem {
    @JsonProperty("Value")
    private String value;

    @JsonProperty("Name")
    private String name;

}
