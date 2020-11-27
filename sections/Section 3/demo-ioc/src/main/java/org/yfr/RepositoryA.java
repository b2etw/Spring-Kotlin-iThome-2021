package org.yfr;

import org.springframework.stereotype.Component;

@Component("repositoryA")
public class RepositoryA implements Repository {

    private String name = "Vincent";

    @Override
    public String returnName() {
        return name;
    }
}
