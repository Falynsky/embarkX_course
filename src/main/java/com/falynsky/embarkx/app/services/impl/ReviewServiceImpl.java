package com.falynsky.embarkx.app.services.impl;

import com.falynsky.embarkx.app.enities.Review;
import com.falynsky.embarkx.app.repositories.CompanyRepository;
import com.falynsky.embarkx.app.repositories.ReviewRepository;
import com.falynsky.embarkx.app.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    @Override
    public List<Review> getReviewsByCompanyId(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        if (reviews == null) {
            throw new NoSuchElementException("No reviews found for selected company id");
        }

        return reviews;
    }

    @Override
    public void addReview(Long companyId, Review review) {
        companyRepository.findById(companyId)
                .ifPresentOrElse(
                        review::setCompany,
                        () -> {
                            throw new NoSuchElementException("Company not found");
                        });

        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        if (reviews == null) {
            throw new NoSuchElementException("No reviews found for selected company id");
        }

        Review foundedReview = reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

        if (foundedReview == null) {
            throw new NoSuchElementException("Review not found");
        }

        return foundedReview;
    }
}
