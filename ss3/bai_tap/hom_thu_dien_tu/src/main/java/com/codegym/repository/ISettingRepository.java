package com.codegym.repository;

import com.codegym.model.Setting;

import java.util.List;

public interface ISettingRepository {
    List<Setting> getAll();

    Setting editSetting(int id);

    List getAllSize();

    List getAllLanguages();

    void updateSetting(Setting setting);
}
