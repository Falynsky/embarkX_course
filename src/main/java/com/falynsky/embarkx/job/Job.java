package com.falynsky.embarkx.job;

import lombok.Data;

@Data
public class Job {

    private Long id;
    private String title;
    private String description;
    private Long minSalary;
    private Long maxSalary;
    private String location;
    private Long version;
}
