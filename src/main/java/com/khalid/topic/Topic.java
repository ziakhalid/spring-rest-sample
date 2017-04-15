package com.khalid.topic;

import com.khalid.com.khalid.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Topic extends BaseEntity {

    private String name;
    private int questionCount;

    protected Topic() {
        super();
    }

    public Topic(String name, int questionCount) {
        this();
        this.name = name;
        this.questionCount = questionCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}
