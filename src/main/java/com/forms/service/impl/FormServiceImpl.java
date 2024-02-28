package com.forms.service.impl;

import com.forms.entity.Form;
import com.forms.repository.FormRepository;
import com.forms.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class FormServiceImpl implements FormService {
    private final FormRepository formRepository;

    @Override
    public List<Form> getAllByUserId(UUID userId) {
        return formRepository.findAllByUserId(userId);
    }

    @Override
    public Form getId(UUID formId) {
        return formRepository.findById(formId).get();
    }

    @Override
    public Form create(Form form) {
        form.setUserId(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
        form.setCreatedDate(LocalDateTime.now());
        form.setLastUpdatedTime(LocalDateTime.now());
        return formRepository.save(form);
    }
    @Override
    public Form update(Form form) {
        form.setUserId(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
        form.setLastUpdatedTime(LocalDateTime.now());
        return formRepository.save(form);
    }
}
