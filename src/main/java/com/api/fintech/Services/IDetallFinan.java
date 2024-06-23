package com.api.fintech.Services;

import com.api.fintech.Models.Client;
import com.api.fintech.Models.DetailsFinanced;

import java.util.List;
import java.util.Optional;

public interface IDetallFinan {

    DetailsFinanced crearDetalle(DetailsFinanced detailsFinanced) throws Exception;
    List<DetailsFinanced> mostrarDetalleFinan();
    DetailsFinanced actualizarDetalleFinan(DetailsFinanced detailsFinanced) throws Exception;
    Optional<DetailsFinanced> detallesFinan(Long id);


}
