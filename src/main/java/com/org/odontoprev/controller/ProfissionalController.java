package com.org.odontoprev.controller;

import com.org.odontoprev.model.Profissional;
import com.org.odontoprev.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profissional_op")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Profissional>> getProfissional(@PathVariable Long id) {
        Profissional profissional = profissionalService.findById(id);
        EntityModel<Profissional> resource = EntityModel.of(profissional);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfissionalController.class).getProfissional(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfissionalController.class).getAllProfissionais()).withRel("all-profissionais"));
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Profissional>>> getAllProfissionais() {
        List<EntityModel<Profissional>> profissionais = profissionalService.findAll().stream()
                .map(profissional -> {
                    EntityModel<Profissional> resource = EntityModel.of(profissional);
                    resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfissionalController.class).getProfissional(profissional.getId())).withSelfRel());
                    return resource;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(profissionais);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Profissional>> createProfissional(@RequestBody Profissional profissional) {
        Profissional createdProfissional = profissionalService.save(profissional);
        EntityModel<Profissional> resource = EntityModel.of(createdProfissional);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfissionalController.class).getProfissional(createdProfissional.getId())).withSelfRel());
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfissionalController.class).getProfissional(createdProfissional.getId())).toUri()).body(resource);
    }
}