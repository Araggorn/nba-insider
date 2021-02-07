package pl.coderslab.nbainsider.list;

import lombok.ToString;


public interface MyList {

    void add(String element);

    void delete(String element);

    void showList();

    void count();
}
