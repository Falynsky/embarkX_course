package com.falynsky.embarkx.app.controllers;

import com.falynsky.embarkx.app.enities.Review;
import com.falynsky.embarkx.app.services.ReviewService;
import com.falynsky.embarkx.app.dto.ReviewDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long companyId) {
        List<Review> reviewsByCompanyId = reviewService.getReviewsByCompanyId(companyId);
        return ResponseEntity.ok(reviewsByCompanyId);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Void> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        reviewService.addReview(companyId, review);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(companyId, reviewId);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody ReviewDTO updatedReview) {
        reviewService.updateReview(companyId, reviewId, updatedReview);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        reviewService.deleteReview(companyId, reviewId);
        return ResponseEntity.ok().build();
    }
}
