package com.doodle.polls;

import com.doodle.polls.beans.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "polls", path = "polls")
public interface PollRepository extends MongoRepository<Poll, String> {

    public Poll findByAdminKey(@Param("adminKey") String adminKey);
    public List<Poll> findByState(@Param("state") String state);

    @Query(value = "{}", fields = "{'_id':1}")
    public List<Poll> findAll();


}