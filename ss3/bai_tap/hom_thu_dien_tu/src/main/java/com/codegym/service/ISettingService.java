package com.codegym.service;

import com.codegym.model.Setting;

import java.util.List;

public interface ISettingService {
    List<Setting> getAll();

    Setting editSetting(int id);

    List getAllSize();

    List getAllLanguages();

    void updateSetting(Setting setting);
}
