package com.riwi.eventos_taller_02.servicies.abtract_service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi.eventos_taller_02.entity.Evento;

public interface EventoIService {
    public List<Evento> getAllEvents();

    public Page<Evento> getAllPages(int page,int size);

    public Evento save(Evento objEvento);

    public Evento getEventoById(String id);

    public Boolean delete(String id);

    public Evento update(Evento objEvento);
}
