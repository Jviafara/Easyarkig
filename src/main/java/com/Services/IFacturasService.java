package com.Services;

import java.util.List;
import com.TO.Facturas;

public interface IFacturasService {

    public List<Facturas> listarFacturas();

    public void eliminar(int idFactura);

    public Facturas guardar(Facturas factura);

    public Facturas buscarFacturas(int idFactura);

    public List<Facturas> facturasPendientes();
}
