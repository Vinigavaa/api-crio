package com.crio.api.controller;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.evento.EventoResquestDTO;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Evento> create(
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("inicio") LocalDateTime inicio,
            @RequestParam("fim") LocalDateTime fim,
            @RequestParam("local") String local,
            @RequestParam("privado") Boolean privado,
            @RequestParam("link_evento") String link_evento,
            @RequestParam("como_chegar") String como_chegar,
            @RequestParam("link_forms") String link_forms,
            @RequestParam("usuario") Usuario usuario
    ){
        EventoResquestDTO eventoResquestDTO = new EventoResquestDTO(
                titulo,
                descricao,
                local,
                inicio,
                fim,
                privado,
                link_evento,
                como_chegar,
                link_forms,
                usuario
        );
        Evento newEvento = this.eventoService.createEvento(eventoResquestDTO);
        return ResponseEntity.ok(newEvento);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEvents(){
        List<Evento> eventos = this.eventoService.getAllEvents();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventById(@PathVariable("id") UUID id){
        Evento evento = this.eventoService.getEventById(id);
        return ResponseEntity.ok(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvent(@PathVariable("id") UUID id, @RequestBody EventoResquestDTO eventoResquestDTO){
        Evento updatedEvento = this.eventoService.updateEvent(id, eventoResquestDTO);
        return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") UUID id){
        this.eventoService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}