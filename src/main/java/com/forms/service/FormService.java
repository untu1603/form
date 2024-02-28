package com.forms.service;

import com.forms.entity.Form;

import java.util.List;
import java.util.UUID;

public interface FormService {
    List<Form> getAllByUserId(UUID userId);

    Form getId(UUID formId);

    Form create(Form form);

    Form update(Form form);
}
