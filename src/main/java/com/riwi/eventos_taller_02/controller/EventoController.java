package com.riwi.eventos_taller_02.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.eventos_taller_02.entity.Evento;
import com.riwi.eventos_taller_02.servicies.abtract_service.EventoIService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventoController {
    
    @Autowired
    private final EventoIService objEventoIService;

    @GetMapping
    public ResponseEntity<Page<Evento>> getAllPage(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "2")int size){
        return ResponseEntity.ok(this.objEventoIService.getAllPages(page -1, size));
    }

    @PostMapping
    public ResponseEntity<Evento> insert(@RequestBody Evento objEvento){
        return ResponseEntity.ok(this.objEventoIService.save(objEvento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable String id){
        Evento objEvento = this.objEventoIService.getEventoById(id);
        this.objEventoIService.delete(objEvento.getId());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@RequestBody Evento objEvento,@PathVariable String id){
        objEvento.setId(id);
        return ResponseEntity.ok(this.objEventoIService.update(objEvento));
    }

}
