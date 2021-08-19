package org.yfr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceA implements Service {

    @Autowired
    private Repository repository;

    @Override
    public String printName() {
        return repository.returnName();
    }
}
