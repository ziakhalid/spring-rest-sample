package com.khalid.topic;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping ("/topics")
public class TopicController {

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping (method = RequestMethod.GET)
    Collection<Topic> getAllTopics(){
        return Lists.newArrayList(topicRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "topicName/{topicName}")
    public Collection<Topic> getTopicByTopicName(@PathVariable String topicName){
        return topicRepository.findByTopicName(topicName);
    }


}
