package com.api.fintech.Services;

import com.api.fintech.Models.Client;
import com.api.fintech.Models.DetailsFinanced;
import com.api.fintech.Repositories.DetailsFinancedRepository;
import com.api.fintech.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DetalleFinanImpl implements IDetallFinan{

    @Autowired
    DetailsFinancedRepository detailsFinancedRepository;
    @Override
    public DetailsFinanced crearDetalle(DetailsFinanced detailsFinanced) throws Exception {
        return detailsFinancedRepository.save(detailsFinanced);
    }

    @Override
    public List<DetailsFinanced> mostrarDetalleFinan() {
        return detailsFinancedRepository.findAll();
    }

    @Override
    public DetailsFinanced actualizarDetalleFinan(DetailsFinanced detailsFinanced) throws Exception {
        Optional<DetailsFinanced> existingDetails = detailsFinancedRepository.findById(Long.valueOf(detailsFinanced.getId()));
        if (!existingDetails.isPresent()) {
            throw new ClientNotFoundException("No hay detalle de financiamiento encontrado con ID: " + detailsFinanced.getId());
        }

        detailsFinancedRepository.save(detailsFinanced);
        return detailsFinanced;
    }

    @Override
    public Optional<DetailsFinanced> detallesFinan(Long id) {
        return Optional.empty();
    }
}
