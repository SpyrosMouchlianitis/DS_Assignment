package com.hua.gr.DS_Assignment.repository;

import com.hua.gr.DS_Assignment.UserCatalog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserCatalogRepository extends JpaRepository<UserCatalog, String> {
}