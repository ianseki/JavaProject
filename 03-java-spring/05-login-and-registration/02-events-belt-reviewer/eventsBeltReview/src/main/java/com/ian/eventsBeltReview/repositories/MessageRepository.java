package com.ian.eventsBeltReview.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ian.eventsBeltReview.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>
{

}
