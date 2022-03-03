
package com.bloodbank.dao;

import java.util.List;

public interface BaseDao<T> {
    boolean save(T ob);
    boolean delete(int id);
    boolean update(T ob);
    List<T> list();
    T get(int id);
}
