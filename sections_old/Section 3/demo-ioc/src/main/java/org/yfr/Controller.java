package org.yfr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    @Autowired
    private Service serviceA;

    public String printName() {
        return serviceA.printName();
    }
}
