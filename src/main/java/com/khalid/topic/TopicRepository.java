package com.khalid.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TopicRepository extends CrudRepository<Topic, Long> {

    //select a from Topic a where a.topicname = :topicname
    Collection<Topic> findByTopicName(String topicName);

}
