package com.falynsky.embarkx.app.services.impl;

import com.falynsky.embarkx.app.enities.Review;
import com.falynsky.embarkx.app.repositories.CompanyRepository;
import com.falynsky.embarkx.app.repositories.ReviewRepository;
import com.falynsky.embarkx.app.services.ReviewService;
import com.falynsky.embarkx.app.to.UpdateReviewTO;
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
        return getReviews(companyId);
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
        return getReview(companyId, reviewId);
    }

    @Override
    public void updateReview(Long companyId, Long reviewId, UpdateReviewTO updatedReview) {
        if (!companyRepository.existsById(companyId)) {
            throw new NoSuchElementException("Company not found");
        }

        if (!reviewRepository.existsById(reviewId)) {
            throw new NoSuchElementException("Review not found");
        }

        Review foundedReview = getReview(companyId, reviewId);

        foundedReview.setRating(updatedReview.getRating() == null ? foundedReview.getRating() : updatedReview.getRating());
        foundedReview.setReview(updatedReview.getReview() == null ? foundedReview.getReview() : updatedReview.getReview());
        foundedReview.setDescription(updatedReview.getDescription() == null ? foundedReview.getDescription() : updatedReview.getDescription());

        reviewRepository.save(foundedReview);
    }

    @Override
    public void deleteReview(Long companyId, Long reviewId) {
        if (!companyRepository.existsById(companyId)) {
            throw new NoSuchElementException("Company not found");
        }

        if (!reviewRepository.existsById(reviewId)) {
            throw new NoSuchElementException("Review not found");
        }

        Review foundedReview = getReview(companyId, reviewId);

        reviewRepository.delete(foundedReview);
    }

    private Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = getReviews(companyId);

        Review foundedReview = reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

        if (foundedReview == null) {
            throw new NoSuchElementException("Review not found");
        }

        return foundedReview;
    }

    private List<Review> getReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        if (reviews == null) {
            throw new NoSuchElementException("No reviews found for selected company id");
        }

        return reviews;
    }
}
