package com.hms.app.components.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.components.models.FooterSection;
@Repository
public interface FooterSectionRepository extends JpaRepository<FooterSection, String>{

}
