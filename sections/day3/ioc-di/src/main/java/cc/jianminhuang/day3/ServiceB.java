package cc.jianminhuang.day3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceB implements Bo {

    @Autowired
    Dao daoB;

    public ServiceB(Dao daoB) {
        this.daoB = daoB;
    }

    @Override
    public String sayHello() {
        return "Hello in ServiceB " + daoB.getValue();
    }

    public void setDaoB(Dao daoB) {
        this.daoB = daoB;
    }
}
