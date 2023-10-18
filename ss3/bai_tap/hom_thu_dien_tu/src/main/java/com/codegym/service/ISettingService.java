package com.codegym.service;

import com.codegym.model.Mail;

import java.util.List;

public interface ISettingService {
    List<Mail> getAll();

    Mail editSetting(int id);

    List getAllSize();

    List getAllLanguages();

    void updateSetting(Mail setting);
}
