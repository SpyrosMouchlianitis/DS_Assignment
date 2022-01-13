package com.hua.gr.DS_Assignment;

// CRUD refers Create, Read, Update, Delete

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen, Integer> {

    List<Citizen> findByFirstName(String firstName);

}
