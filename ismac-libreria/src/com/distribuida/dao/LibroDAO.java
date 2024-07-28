package com.distribuida.dao;

import java.util.List;
import com.distribuida.entities.Libro;

public interface LibroDAO {

    List<Libro> findAll();

    Libro findOne(int id);

    void add(Libro libro);

    void up(Libro libro);

    void del(int id);
}