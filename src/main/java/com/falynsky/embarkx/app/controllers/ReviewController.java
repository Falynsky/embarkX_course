package com.falynsky.embarkx.app.controllers;

import com.falynsky.embarkx.app.services.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;
}
