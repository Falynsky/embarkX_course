package com.falynsky.embarkx.app.services;

import com.falynsky.embarkx.app.enities.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByCompanyId(Long companyId);

    void addReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);
}
