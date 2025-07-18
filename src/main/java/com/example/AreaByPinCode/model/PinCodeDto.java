package com.example.AreaByPinCode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PinCodeDto {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("District")
    private String district;
    @JsonProperty("State")
    private String state;

}
