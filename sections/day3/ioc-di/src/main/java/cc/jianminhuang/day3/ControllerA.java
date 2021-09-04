package cc.jianminhuang.day3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerA {

    @Autowired
    Bo serviceA;

    @Autowired
    public ControllerA(Bo serviceA) {
        this.serviceA = serviceA;
    }

    String sayHello() {
        return serviceA.sayHello();
    }

    public void setServiceA(Bo serviceA) {
        this.serviceA = serviceA;
    }
}
