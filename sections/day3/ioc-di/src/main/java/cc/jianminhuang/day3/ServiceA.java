package cc.jianminhuang.day3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceA implements Bo {

    @Autowired
    Dao daoA;

    public ServiceA(Dao daoA) {
        this.daoA = daoA;
    }

    @Override
    public String sayHello() {
        return "Hello in ServiceA " + daoA.getValue();
    }

    public void setDaoA(Dao daoA) {
        this.daoA = daoA;
    }
}
