package com.forms.controller;

import com.forms.entity.Form;
import com.forms.service.FormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController @Slf4j
@RequestMapping("/forms")
public class FormController {
    private final FormService formService;
    @GetMapping("")
    public List<Form> getAll()
    {
        return formService.getAllByUserId(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
    }
    @GetMapping("/{id}")
    public Form getId(@PathVariable(value = "id") UUID id)
    {
        return formService.getId(id);
    }
    @PostMapping("")
    public Form creat(@RequestBody Form form)
    {
        return formService.create(form);
    }
    @PutMapping("/{id}")
    public Form update(@PathVariable(value = "id") UUID id,@RequestBody Form form)
    {   form.setFormId(id);
        return formService.update(form);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") UUID id)
    {
         formService.delete(id);
         return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
