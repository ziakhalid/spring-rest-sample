package com.khalid.com.khalid.core;

import com.khalid.topic.Topic;
import com.khalid.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner{

    private TopicRepository topics;

    @Autowired
    public DatabaseLoader(TopicRepository topics) {
        this.topics = topics;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ArrayList<Topic> bunchOfTopic = new ArrayList<Topic>();

        String[] buzzWords = {"Multi Threading", "Inner Classes", "Collections", "Generics", "Development", "JVM"};

        //Using java 8 features (stream, lambda)
        IntStream.range(0,10).forEach(it -> {
            String buzzWord = buzzWords[it % buzzWords.length];
            Topic topic = new Topic(buzzWord, (it % buzzWords.length));
            bunchOfTopic.add(topic);
        });

        topics.save(bunchOfTopic);
    }
}
