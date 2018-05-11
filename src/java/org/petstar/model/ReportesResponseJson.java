package org.petstar.model;

import java.util.HashMap;
import java.util.List;
import org.petstar.dto.LineasDTO;
import org.petstar.dto.PeriodosDTO;

/**
 * @author Tech-Pro
 */
public class ReportesResponseJson {
    private List<HashMap> listaOEEFallas;
    private List<LineasDTO> listLineas;
    private List<PeriodosDTO> listPeriodos;
    private List<HashMap> reporteDisponibilidad;
    private List<HashMap> datosProduccion;
    private List<HashMap> reporteOEE;

    public List<HashMap> getListaOEEFallas() {
        return listaOEEFallas;
    }

    public void setListaOEEFallas(List<HashMap> listaOEEFallas) {
        this.listaOEEFallas = listaOEEFallas;
    }

    public List<LineasDTO> getListLineas() {
        return listLineas;
    }

    public void setListLineas(List<LineasDTO> listLineas) {
        this.listLineas = listLineas;
    }

    public List<PeriodosDTO> getListPeriodos() {
        return listPeriodos;
    }

    public void setListPeriodos(List<PeriodosDTO> listPeriodos) {
        this.listPeriodos = listPeriodos;
    }

    public List<HashMap> getReporteDisponibilidad() {
        return reporteDisponibilidad;
    }

    public void setReporteDisponibilidad(List<HashMap> reporteDisponibilidad) {
        this.reporteDisponibilidad = reporteDisponibilidad;
    }
    
    public List<HashMap> getDatosProduccion() {
        return datosProduccion;
    }

    public void setDatosProduccion(List<HashMap> datosProduccion) {
        this.datosProduccion = datosProduccion;
    }

    public List<HashMap> getReporteOEE() {
        return reporteOEE;
    }

    public void setReporteOEE(List<HashMap> reporteOEE) {
        this.reporteOEE = reporteOEE;
    }
}
