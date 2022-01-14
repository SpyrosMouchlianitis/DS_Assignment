package com.hua.gr.DS_Assignment;

// CRUD refers Create, Read, Update, Delete

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen, Integer> {

    @Query("SELECT u from citizen u where u.firstName = ?1")
    List<Citizen> findByFirstName(String firstName);

}
