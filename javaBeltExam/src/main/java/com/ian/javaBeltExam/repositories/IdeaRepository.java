package com.ian.javaBeltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ian.javaBeltExam.models.Idea;

public interface IdeaRepository extends CrudRepository<Idea, Long>
{
	List<Idea> findAll();
}
