package com.org.odontoprev.controller;

import com.org.odontoprev.model.Consulta;
import com.org.odontoprev.service.ConsultaService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consulta_op")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Consulta>> getConsulta(@PathVariable Long id) {
        Consulta consulta = consultaService.findById(id);
        EntityModel<Consulta> resource = EntityModel.of(consulta);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsultaController.class).getConsulta(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsultaController.class).getAllConsultas()).withRel("all-consultas"));
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Consulta>>> getAllConsultas() {
        List<EntityModel<Consulta>> consultas = consultaService.findAll().stream()
                .map(consulta -> {
                    EntityModel<Consulta> resource = EntityModel.of(consulta);
                    resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsultaController.class).getConsulta(consulta.getId())).withSelfRel());
                    return resource;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(consultas);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Consulta>> createConsulta(@RequestBody Consulta consulta) {
        Consulta createdConsulta = consultaService.save(consulta);
        EntityModel<Consulta> resource = EntityModel.of(createdConsulta);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsultaController.class).getConsulta(createdConsulta.getId())).withSelfRel());
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsultaController.class).getConsulta(createdConsulta.getId())).toUri()).body(resource);
    }
}
