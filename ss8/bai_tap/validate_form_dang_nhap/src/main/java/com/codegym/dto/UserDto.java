package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UserDto implements Validator {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
//        this.firstName =firstName;
//        this.lastName =lastName;
//        this.phoneNumber =phoneNumber;
//        this.age =age;
//        this.email =email;
    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().length() < 5) {
            errors.rejectValue("firstName",null,"Tổng số ký tự phải lớn hơn hoặc bằng 5");
        } else if (userDto.getFirstName().length() > 45) {
            errors.rejectValue("firstName",null,"Tổng số Ký tự không thể vượt quá 45");
        } else if (userDto.getFirstName().length() < 5) {
            errors.rejectValue("lastName",null,"Tổng số ký tự phải lớn hơn hoặc bằng 5");
        } else if (userDto.getFirstName().length() > 45) {
            errors.rejectValue("lastName",null,"Tổng số Ký tự không thể vượt quá 45");
        } else if (userDto.getAge() < 18) {
            errors.rejectValue("age",null,"Tuổi phải lớn hơn 18 hoặc bằng 18");
        } else if (!userDto.phoneNumber.matches("((09|03|07|08|05)+([0-9]{8})\\b)")) {
            errors.rejectValue("phoneNumber",null,"Số điện thoại bạn nhập chưa đứng xin lòng nhập lại");
        } else if (!userDto.getEmail().matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {
            errors.rejectValue("email",null,"Gmail bạn nhập chưa đứng yêu cầu xin vui lòng nhập lại");
        }
    }
}
