package com.codegym.repository;

import com.codegym.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SettingRepository implements ISettingRepository{
    private static List<Mail> settingList = new ArrayList<>();
    private static  List<String> stringList = new ArrayList<>();

    private static List<Integer> integerList = new ArrayList<>();

    static {
        settingList.add(new Mail(1,"Vietnamese",15,true,"King,Asgard"));

        stringList.add("English");
        stringList.add("Vietnamese");
        stringList.add("Japanese");
        stringList.add("Chinese");


        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        integerList.add(20);
        integerList.add(25);
    }

    @Override
    public List<Mail> getAll() {
        return settingList;
    }

    @Override
    public Mail editSetting(int id) {
        for (int i = 0; i < settingList.size(); i++) {
            if (settingList.get(i).getId() == id){
                return settingList.get(i);
            }
        }
        return null;
    }

    @Override
    public List getAllSize() {
        return integerList;
    }

    @Override
    public List getAllLanguages() {
        return stringList;
    }

    @Override
    public void updateSetting(Mail setting) {
        for (int i = 0; i < settingList.size(); i++) {
            if (settingList.get(i).getId() == setting.getId()){
                settingList.get(i).setLanguages(setting.getLanguages());
                settingList.get(i).setSize(setting.getSize());
                settingList.get(i).setSpamsFilter(setting.getSpamsFilter());
                settingList.get(i).setSignature(setting.getSignature());
            }
        }
    }
}
