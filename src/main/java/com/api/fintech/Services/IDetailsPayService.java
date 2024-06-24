package com.api.fintech.Services;

import com.api.fintech.Models.DetailsPayfin;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public interface IDetailsPayService {

    DetailsPayfin pagar(DetailsPayfin pagos);
}
