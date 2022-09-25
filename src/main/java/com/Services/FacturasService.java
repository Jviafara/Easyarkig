package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DAO.FacturasDAO;
import com.TO.Facturas;

@Service
public class FacturasService implements IFacturasService {

    @Autowired
    private FacturasDAO facturasdao;

    @Override
    @Transactional(readOnly = true)
    public List<Facturas> listarFacturas() {
        return (List<Facturas>) facturasdao.findAll();
    }

    @Override
    public void eliminar(int idFacturas) {
        facturasdao.deleteById(idFacturas);
    }

    @Override
    @Transactional
    public Facturas guardar(Facturas factura) {
        return facturasdao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Facturas buscarFacturas(int idFacturas) {
        return facturasdao.findById(idFacturas).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Facturas> facturasPendientes() {
        return (List<Facturas>) facturasdao.facturasPendientes();
    }
}
