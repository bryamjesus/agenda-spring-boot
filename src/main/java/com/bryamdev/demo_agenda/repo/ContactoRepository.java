package com.bryamdev.demo_agenda.repo;

import com.bryamdev.demo_agenda.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
}
