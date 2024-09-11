package com.crio.api.controller;


import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.endereco.EnderecoRequestDTO;
import com.crio.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
        
    @Autowired
        private EnderecoService enderecoService;

        @PostMapping(consumes = "multipart/form-data")
        public ResponseEntity<Endereco> create (
                @RequestParam("city") String city,
                @RequestParam("uf") String uf){
            EnderecoRequestDTO enderecoRequestDTO = new EnderecoRequestDTO(city,uf);
            Endereco newEndereco = this.enderecoService.createEndereco(enderecoRequestDTO);
            return ResponseEntity.ok(newEndereco);
        }

        //retornar todos os Enderecos
        @GetMapping
        public ResponseEntity<List<Endereco>> getAllEnderecos(){
            List<Endereco> Enderecos = this.enderecoService.getAllEnderecos();
            //retorna list todos os Enderecos
            return ResponseEntity.ok(Enderecos);
        }

        //retornar o Endereco pelo Id
        @GetMapping("/{id}")
        public ResponseEntity<Endereco> getEnderecoById(@PathVariable("id") UUID id){
            Endereco Endereco = this.enderecoService.getEnderecoById(id);
            return ResponseEntity.ok(Endereco);
        }

        //atualizar os dados do Endereco
        @PutMapping("/{id}")
        public ResponseEntity<Endereco> updateEndereco(@PathVariable("id") UUID id, @RequestBody EnderecoRequestDTO enderecoRequestDTO){
            Endereco updatedEndereco = this.enderecoService.updateEndereco(id, enderecoRequestDTO);
            return ResponseEntity.ok(updatedEndereco);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEndereco(@PathVariable("id") UUID id){
            this.enderecoService.deleteEndereco(id);
            return ResponseEntity.noContent().build();
        }

    }
    
