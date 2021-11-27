package com.lab6.dto;

import com.lab6.models.Career;
import com.lab6.models.Transport;

public class TransportDto {
    private Transport transport;

    public TransportDto(Transport transport) {
        this.transport = transport;
    }

    public int getId() {
        return transport.getId();
    }

    public String getModel() {
        return transport.getModel();
    }

    public String getTransportcol() {
        return transport.getTransportcol();
    }

    public Career getCareerId() {
        return transport.getCareerId();
    }
}
