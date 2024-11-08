package com.org.odontoprev.controller;

import com.org.odontoprev.model.Paciente;
import com.org.odontoprev.service.PacienteService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes_op")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Paciente>> getPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.findById(id);
        EntityModel<Paciente> resource = EntityModel.of(paciente);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PacienteController.class).getPaciente(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PacienteController.class).getAllPacientes()).withRel("all-pacientes"));
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Paciente>>> getAllPacientes() {
        List<EntityModel<Paciente>> pacientes = pacienteService.findAll().stream()
                .map(paciente -> {
                    EntityModel<Paciente> resource = EntityModel.of(paciente);
                    resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PacienteController.class).getPaciente(paciente.getId())).withSelfRel());
                    return resource;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Paciente>> createPaciente(@RequestBody Paciente paciente) {
        Paciente createdPaciente = pacienteService.save(paciente);
        EntityModel<Paciente> resource = EntityModel.of(createdPaciente);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PacienteController.class).getPaciente(createdPaciente.getId())).withSelfRel());
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PacienteController.class).getPaciente(createdPaciente.getId())).toUri()).body(resource);
    }
}
