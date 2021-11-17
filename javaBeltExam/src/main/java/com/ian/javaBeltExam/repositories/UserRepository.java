package com.ian.javaBeltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ian.javaBeltExam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	List<User> findAll();
	User findByEmail(String email);
}
