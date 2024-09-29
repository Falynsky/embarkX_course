package com.falynsky.embarkx.app.services;

import com.falynsky.embarkx.app.enities.Review;
import com.falynsky.embarkx.app.to.UpdateReviewTO;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByCompanyId(Long companyId);

    void addReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);

    void updateReview(Long companyId, Long reviewId, UpdateReviewTO updatedReview);

    void deleteReview(Long companyId, Long reviewId);
}
