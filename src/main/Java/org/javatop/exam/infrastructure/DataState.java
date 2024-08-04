package org.javatop.exam.infrastructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DataState implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> topicNumList = new ArrayList<>();
    private String loggedInUser;

    public List<String> getTopicNumList() {
        return topicNumList;
    }

    public void setTopicNumList(List<String> topicNumList) {
        this.topicNumList = topicNumList;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
