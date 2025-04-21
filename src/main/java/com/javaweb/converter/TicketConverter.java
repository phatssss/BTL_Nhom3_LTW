package com.javaweb.converter;

import com.javaweb.config.ModelMapperConfig;
import com.javaweb.entity.TicketEntity;
import com.javaweb.model.dto.TicketDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import sun.security.krb5.internal.Ticket;

@Component
public class TicketConverter {

    @Autowired
    private ModelMapper modelMapper;

    public TicketDTO toDTO(TicketEntity item) {
        return modelMapper.map(item, TicketDTO.class);
    }

    public TicketEntity toEntity(TicketDTO dto) {
        return modelMapper.map(dto, TicketEntity.class);
    }
}
