package com.hms.app.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.app.pages.models.Page;

public interface PageRepository extends JpaRepository<Page, String> {

}
