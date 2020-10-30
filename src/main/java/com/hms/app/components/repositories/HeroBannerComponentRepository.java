package com.hms.app.components.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.components.HeroBannerComponent;
@Repository
public interface HeroBannerComponentRepository extends JpaRepository<HeroBannerComponent, String> {

}
