package com.virajmavani.Bifrost.model;

import java.util.List;

public class Query {
    public String search_str;
    public List<String> targets;

    Query() {
    }

    Query(String search_str, List<String> targets) {
        this.search_str = search_str;
        this.targets = targets;
    }

    public String getSearch_str() {
        return search_str;
    }

    public void setSearch_str(String search_str) {
        this.search_str = search_str;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }
}
