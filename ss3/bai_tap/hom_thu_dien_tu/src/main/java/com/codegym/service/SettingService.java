package com.codegym.service;

import com.codegym.model.Setting;
import com.codegym.repository.ISettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SettingService implements ISettingService{
    @Autowired
    private ISettingRepository settingRepository;

    @Override
    public List<Setting> getAll() {
        return settingRepository.getAll();
    }

    @Override
    public Setting editSetting(int id) {
        return settingRepository.editSetting(id);
    }

    @Override
    public List getAllSize() {
        return settingRepository.getAllSize();
    }

    @Override
    public List getAllLanguages() {
        return settingRepository.getAllLanguages();
    }

    @Override
    public void updateSetting(Setting setting) {
        settingRepository.updateSetting(setting);
    }
}
