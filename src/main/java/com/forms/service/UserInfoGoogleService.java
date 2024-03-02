package com.forms.service;

import com.forms.entity.Form;

import java.util.List;
import java.util.UUID;

public interface UserInfoGoogleService {
    List<Form> getAllByUserId(String token);

}
