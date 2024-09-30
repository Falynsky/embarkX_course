package com.falynsky.embarkx.app.services;

import com.falynsky.embarkx.app.enities.Review;
import com.falynsky.embarkx.app.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByCompanyId(Long companyId);

    void addReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);

    void updateReview(Long companyId, Long reviewId, ReviewDTO updatedReview);

    void deleteReview(Long companyId, Long reviewId);
}
