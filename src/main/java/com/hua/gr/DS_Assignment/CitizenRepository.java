package com.hua.gr.DS_Assignment;

// CRUD refers Create, Read, Update, Delete

import org.springframework.data.repository.CrudRepository;

public interface CitizenRepository extends CrudRepository<Citizen, Integer> {
}
