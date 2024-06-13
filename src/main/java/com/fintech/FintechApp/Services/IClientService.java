package com.fintech.FintechApp.Services;

import com.fintech.FintechApp.Models.Client;

public interface IClientService {
    void save(Client cliente);
    Client update(Long id);
}
