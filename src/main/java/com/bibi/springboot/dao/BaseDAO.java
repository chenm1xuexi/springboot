package com.bibi.springboot.dao;

public interface BaseDAO<T, V> {
    T create(T t);
    T update(T t);
    T getById(V id);
    void delete(V id);
}
