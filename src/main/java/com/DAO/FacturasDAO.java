package com.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.TO.Facturas;

public interface FacturasDAO extends CrudRepository<Facturas, Integer> {

    @Query(value = "SELECT * FROM Facturas WHERE codigoFactura='0' ", nativeQuery = true)
    List<Facturas> facturasPendientes();

}
