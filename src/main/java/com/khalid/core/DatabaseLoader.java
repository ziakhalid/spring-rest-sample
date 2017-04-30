package com.khalid.core;

import com.khalid.topic.Topic;
import com.khalid.topic.TopicRepository;
import com.khalid.user.User;
import com.khalid.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private TopicRepository topics;
    private UserRepository users;


    @Autowired
    public DatabaseLoader(TopicRepository topics, UserRepository users) {
        this.topics = topics;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<User> students = Arrays.asList(
                new User("Reza", "Khalid", "rezakhalid", "password", new String[]{"ROLE_USER"}),
                new User("Satyaveer", "Singh", "satyveer_singh", "password", new String[]{"ROLE_USER"}),
                new User("Satish", "Yadav", "satishyadav", "password", new String[]{"ROLE_USER"}),
                new User("Farzan", "Ahmad", "farzan_ahmad", "password", new String[]{"ROLE_USER"})
        );
        users.save(students);

        users.save(new User("zia", "khalid", "zia566", "123456", new String[]{"ROLE_USER", "ROLE_ADMIN"}));

        ArrayList<Topic> bunchOfTopic = new ArrayList<Topic>();

        String[] buzzWords = {"Multi Threading", "Inner Classes", "Collections", "Generics", "Development", "JVM"};

        //Using java 8 features (stream, lambda)
        IntStream.range(0, 10).forEach(it -> {
            String buzzWord = buzzWords[it % buzzWords.length];
            Topic topic = new Topic(buzzWord, (it % buzzWords.length));
            bunchOfTopic.add(topic);
        });

        topics.save(bunchOfTopic);
    }
}
