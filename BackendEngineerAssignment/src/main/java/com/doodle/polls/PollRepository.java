package com.doodle.polls;

import com.doodle.polls.beans.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "polls", path = "polls")
public interface PollRepository extends MongoRepository<Poll, String> {

    List<Poll> findByInitiatedAfter(@Param("time") long time);

    @Query("{ $text : { $search: ?0 } }")
    List<Poll> findByText(@Param("text") String text);

}