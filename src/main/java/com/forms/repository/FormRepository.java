package com.forms.repository;

import com.forms.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FormRepository extends JpaRepository<Form, UUID> {
    List<Form> findAllByUserId(UUID userId);
}
