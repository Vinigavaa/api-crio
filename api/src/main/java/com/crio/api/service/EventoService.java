package com.crio.api.service;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.evento.EventoResquestDTO;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.repositorie.EventoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento createEvento(EventoResquestDTO data) {
        Evento newEvento = new Evento();

        newEvento.setTitulo(data.titulo());
        newEvento.setDescricao(data.descricao());
        newEvento.setLocal(data.local());
        newEvento.setInicio(data.inicio());
        newEvento.setFim(data.fim());
        newEvento.setPrivado(data.privado());
        newEvento.setUsuario(data.usuario());
        newEvento.setLink_evento(data.link_evento());
        newEvento.setComo_chegar(data.como_chegar());
        newEvento.setLink_forms(data.link_forms());
        eventoRepository.save(newEvento);
        return newEvento;
    }

    public List<Evento> getAllEvents() {
        return eventoRepository.findAll();
    }

    public Evento getEventById(UUID id) {
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado."));
    }

    public Evento updateEvent(UUID id, EventoResquestDTO eventoResquestDTO) {
            Evento updateEvent = getEventById(id);
            updateEvent.setTitulo(eventoResquestDTO.titulo());
            updateEvent.setDescricao(eventoResquestDTO.descricao());
            updateEvent.setLocal(eventoResquestDTO.local());
            updateEvent.setInicio(eventoResquestDTO.inicio());
            updateEvent.setFim(eventoResquestDTO.fim());
            updateEvent.setPrivado(eventoResquestDTO.privado());
            updateEvent.setLink_evento(eventoResquestDTO.link_evento());
            updateEvent.setComo_chegar(eventoResquestDTO.como_chegar());
            updateEvent.setLink_forms(eventoResquestDTO.link_forms());
            updateEvent.setUsuario(eventoResquestDTO.usuario());
            return eventoRepository.save(updateEvent);
        }

    public void deleteEvent(UUID id) {
        Evento evento = getEventById(id);
        eventoRepository.delete(evento);
    }
}

