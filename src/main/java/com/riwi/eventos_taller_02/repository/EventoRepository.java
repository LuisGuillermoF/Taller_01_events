package com.riwi.eventos_taller_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.eventos_taller_02.entity.Evento;


@Repository
public interface EventoRepository extends JpaRepository<Evento,String>{

}
