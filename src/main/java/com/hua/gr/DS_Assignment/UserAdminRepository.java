package com.hua.gr.DS_Assignment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAdminRepository extends JpaRepository<UserAdmin, String> {

    List<UserAdmin> findByUsernameAndPassword(String username, String password);

}