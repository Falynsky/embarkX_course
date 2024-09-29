package com.falynsky.embarkx.app.to;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateJobTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("minSalary")
    private Long minSalary;

    @JsonProperty("maxSalary")
    private Long maxSalary;

    @JsonProperty("location")
    private String location;

    @JsonProperty("companyId")
    private Long companyId;

}
