package com.falynsky.embarkx.app.repositories;

import com.falynsky.embarkx.app.enities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
