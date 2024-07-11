package org.javatop.exam.infrastructure;

import java.util.ArrayList;
import java.util.List;


public class DataState {

    private List<String> topicNumList = new ArrayList<>();

    public List<String> getTopicNumList() {
        return topicNumList;
    }

    public void setTopicNumList(List<String> topicNumList) {
        this.topicNumList = topicNumList;
    }

}
