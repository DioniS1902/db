package com.lab6.service;

import com.lab6.models.Transport;
import com.lab6.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class TransportService {

    @Autowired
    public TransportRepository transportRepository;

    public Transport addTransport(final Transport transport) {
        return transportRepository.save(transport);
    }

    public Transport updateTransport(final Transport transport) {
        return transportRepository.save(transport);
    }

    public List<Transport> getTransport() {
        return transportRepository.findAll();
    }

    public Transport getTransportId(final Integer id) {
        return transportRepository.findById(id).orElse(null);
    }

    public void deleteTransportById(Integer id){
        transportRepository.deleteById(id);
    }
}
