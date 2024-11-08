package com.org.odontoprev.service;

import com.org.odontoprev.model.Profissional;
import com.org.odontoprev.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<Profissional> findAll() {
        return profissionalRepository.findAll();
    }

    public Profissional findById(Long id) {
        return profissionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado com ID: " + id));
    }

    public Profissional save(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    public void deleteById(Long id) {
        if (!profissionalRepository.existsById(id)) {
            throw new RuntimeException("Profissional não encontrado com ID: " + id);
        }
        profissionalRepository.deleteById(id);
    }
}

