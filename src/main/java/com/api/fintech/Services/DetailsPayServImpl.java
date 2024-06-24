package com.api.fintech.Services;

import com.api.fintech.Models.DetailsPayfin;
import com.api.fintech.Repositories.DetailsPayfinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsPayServImpl implements IDetailsPayService{

    @Autowired
    DetailsPayfinRepository payfinRepository;
    @Override
    public DetailsPayfin pagar(DetailsPayfin pagos) {
        return payfinRepository.save(pagos);
    }
}
