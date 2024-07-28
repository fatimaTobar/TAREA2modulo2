package com.distribuida.dao;

import java.util.List;
import com.distribuida.entities.FacturaDetalle;

public interface FacturaDetalleDAO {

    List<FacturaDetalle> findAll();

    FacturaDetalle findOne(int id);

    void add(FacturaDetalle detalle);

    void up(FacturaDetalle detalle);

    void del(int id);
}
