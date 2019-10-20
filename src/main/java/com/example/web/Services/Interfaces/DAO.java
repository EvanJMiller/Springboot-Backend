package com.example.web.Services.Interfaces;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> findById(long id);
    List<T> getAll();
    String create(T t);
    T update(T t);
    T delete(T t);
}
