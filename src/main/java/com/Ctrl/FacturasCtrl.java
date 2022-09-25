package com.Ctrl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Services.ConfiguracionesService;
import com.Services.FacturasService;
import com.Services.PersonasService;
import com.Services.PlazasService;
import com.TO.Configuraciones;
import com.TO.Facturas;
import com.TO.Plazas;

@Controller
public class FacturasCtrl {

    @Autowired
    private FacturasService facturasService;
    @Autowired
    private PersonasService personasService;
    @Autowired
    private PlazasService plazasService;
    @Autowired
    private PlazasCtrl plazasCtrl;
    @Autowired
    private ConfiguracionesService configuracionesService;

    /* METODOS HTML */
    // LISTAR
    @GetMapping("/facturas")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Facturas");
        iniciar(model);
        return "facturas";
    }

    @GetMapping("/ingreso")
    public String ingreso(Model model) {
        model.addAttribute("titulo", "Igreso de Vehiculos");
        iniciar(model);
        return "ingreso";

    }

    private void iniciar(Model model) {
        if (model.getAttribute("factura") == null) {
            Facturas factura = new Facturas();
            model.addAttribute("factura", factura);
        }
        var facturas = facturasService.listarFacturas();
        model.addAttribute("facturas", facturas);
        var facturasPendientes = facturasService.facturasPendientes();
        model.addAttribute("facturasPendientes", facturasPendientes);
        var personas = personasService.listarPersonas();
        model.addAttribute("personas", personas);
        var plazas = plazasService.listarPlazas();
        model.addAttribute("plazas", plazas);
    }

    // GUARDAR
    @PostMapping("/facturas/guardar")
    public String guardar(Facturas factura) {
        final Date fecha = new Date();
        factura.setFechaSalida(fecha);
        factura.setValor(0.0);
        factura.setTipoContrato("normal");
        factura.setIdPersonas(1);
        facturasService.guardar(factura);
        return "redirect:/facturas";
    }

    // ELIMINAR
    @GetMapping(value = "/facturas/eliminar/{idFacturas}")
    public String eliminar(Facturas factura) {
        facturasService.eliminar(factura.getIdFacturas());
        return "redirect:/facturas";
    }

    // INGRESAR CARROS
    @GetMapping(value = "/ingreso/carro")
    public String ingresarCarro(Facturas factura, Model model) {
        model.addAttribute("factura", factura);
        var plazasLibres = plazasService.PlazasLibresxTipo("carro");
        model.addAttribute("plazasLibres", plazasLibres);
        iniciar(model);
        return "ingreso";
    }

    // SALIDA CARROS
    @GetMapping(value = "/facturascarro")
    public String facturasCarro(Facturas factura, Model model) {
        iniciar(model);
        return "facturas";
    }

    // INGRESAR MOTOS
    @GetMapping(value = "/ingreso/moto")
    public String ingresarMoto(Facturas factura, Model model) {
        model.addAttribute("factura", factura);
        var plazasLibres = plazasService.PlazasLibresxTipo("moto");
        model.addAttribute("plazasLibres", plazasLibres);
        iniciar(model);
        return "ingreso";
    }

    // SALIDA MOTOS
    @GetMapping(value = "/facturasmoto")
    public String facturasMoto(Facturas factura, Model model) {
        iniciar(model);
        return "facturas";
    }

    // Igresar vehiculo
    @PostMapping("/ingresarVehiculo")
    public String ingresarVehiculo(Facturas factura) {
        final Date fecha = new Date();
        Plazas plaza = new Plazas();
        plaza = plazasService.buscarPlazas(factura.getIdPlazas());
        plaza.setEstado("ocupada");
        plazasCtrl.guardar(plaza);
        factura.setFechaEntrada(fecha);
        factura.setTipoContrato("normal");
        factura.setIdPersonas(1);
        factura.setCodigoFactura(0);
        factura.setPlazaAsociada(plaza.getCodigoPlaza());
        facturasService.guardar(factura);
        return "redirect:/ingreso";
    }

    // Salida vehiculo
    @GetMapping("/salidaVehiculo/{IdFacturas}")
    public String salidaVehiculo(Facturas factura, Model model) {
        String tipoVehiculo = "";
        factura = facturasService.buscarFacturas(factura.getIdFacturas());
        model.addAttribute("factura", factura);
        final Date fecha = new Date();
        Plazas plaza = new Plazas();
        plaza = plazasService.buscarPlazas(factura.getIdPlazas());
        plaza.setEstado("libre");
        plazasCtrl.guardar(plaza);
        if (plaza.getTipoPlaza().equals("carro")) {
            tipoVehiculo = "carro";
        } else {
            tipoVehiculo = "moto";
        }
        factura.setFechaSalida(fecha);
        factura.setFechaFactura(fecha);
        if (tipoVehiculo.equals("carro")) {
            factura = calcularValorCarro(factura);
        }
        factura.setCodigoFactura(factura.getIdFacturas());
        facturasService.guardar(factura);
        return "redirect:/facturas";
    }

    public Facturas calcularValorCarro(Facturas factura) {

        int timeDiff = (int) ((factura.getFechaSalida().getTime() - factura.getFechaEntrada().getTime()) / (1000 * 60));
        Configuraciones configuracion = configuracionesService.buscarConfiguraciones(1);
        if (timeDiff < 15) {
            double valor = configuracion.getValorFracCarro();
            factura.setValor(valor);
        } else if (timeDiff > 15) {
            if (timeDiff <= 65) {
                double valor = configuracion.getValorHoraCarro();
                factura.setValor(valor);
            }
        }
        return factura;
    }
}
