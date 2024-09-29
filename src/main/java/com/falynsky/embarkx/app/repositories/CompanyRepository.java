package com.falynsky.embarkx.app.repositories;

import com.falynsky.embarkx.app.enities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
