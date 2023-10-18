package com.codegym.service;

import com.codegym.model.Mail;
import com.codegym.repository.ISettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SettingService implements ISettingService{
    @Autowired
    private ISettingRepository settingRepository;

    @Override
    public List<Mail> getAll() {
        return settingRepository.getAll();
    }

    @Override
    public Mail editSetting(int id) {
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
    public void updateSetting(Mail setting) {
        settingRepository.updateSetting(setting);
    }
}
