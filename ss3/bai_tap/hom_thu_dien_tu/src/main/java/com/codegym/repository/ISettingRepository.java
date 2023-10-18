package com.codegym.repository;

import com.codegym.model.Mail;

import java.util.List;

public interface ISettingRepository {
    List<Mail> getAll();

    Mail editSetting(int id);

    List getAllSize();

    List getAllLanguages();

    void updateSetting(Mail setting);
}
