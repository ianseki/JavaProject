package com.ian.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ian.languages.models.Languages;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long>
{
	// This method retrieves all languages from database
	List<Languages> findAll();
}
