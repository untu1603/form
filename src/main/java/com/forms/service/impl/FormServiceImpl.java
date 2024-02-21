package com.forms.service.impl;

import com.forms.entity.Form;
import com.forms.repository.FormRepository;
import com.forms.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Form create(Form form) {
        return formRepository.save(form);
    }
}
