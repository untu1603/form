package com.forms.controller;

import com.forms.entity.Form;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/oAuth2")
public class Oauth2Controller {
    @PostMapping("/google")
    public Form creat(@RequestHeader("AcessToken") String bearerToken)
    {
        return null;
    }
}
