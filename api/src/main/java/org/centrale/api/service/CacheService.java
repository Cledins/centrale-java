package org.centrale.api.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CacheService {
    private List<String> myList;

    public CacheService(){
        myList = new ArrayList<>();
    }

    public List<String> getMyList(){
        return myList;
    }

    public void add(String s){
        myList.add(s);
    }

}
