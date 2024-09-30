package com.falynsky.embarkx.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewDTO {

    @JsonProperty("review")
    private String review;

    @JsonProperty("description")
    private String description;

    @JsonProperty("rating")
    private Double rating;

}
