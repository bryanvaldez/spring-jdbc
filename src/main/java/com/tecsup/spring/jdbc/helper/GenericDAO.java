package com.tecsup.spring.jdbc.helper;

import java.util.List;

public interface GenericDAO<T> {
public List<T> list();
public T get(Long id);
public void save(T t);
public void update(T t);
public void delete(T t);
}
//