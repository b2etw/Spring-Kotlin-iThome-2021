package cc.jianminhuang.day3;

import org.springframework.stereotype.Repository;

@Repository
public class DaoA implements Dao {

    @Override
    public String getValue() {
        return "DaoA";
    }
}
