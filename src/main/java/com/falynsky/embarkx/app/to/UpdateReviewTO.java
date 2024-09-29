package com.falynsky.embarkx.app.to;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateReviewTO {

    @JsonProperty("review")
    private String review;

    @JsonProperty("description")
    private String description;

    @JsonProperty("rating")
    private Double rating;

}
