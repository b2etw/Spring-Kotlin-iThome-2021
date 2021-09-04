package cc.jianminhuang.day3;

import org.springframework.stereotype.Repository;

@Repository
public class DaoB implements Dao {

    @Override
    public String getValue() {
        return "DaoB";
    }
}
