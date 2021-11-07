package com.library.web.libraryweb.service;

import java.util.List;

import com.library.web.libraryweb.model.Vartotojas;
import com.library.web.libraryweb.repository.VartotojasRepository;
import com.library.web.libraryweb.validation.EmailValidator;
import com.library.web.libraryweb.validation.PasswordChecker;
import com.library.web.libraryweb.validation.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class VartotojasService {

    EmailValidator emailValidator = new EmailValidator();
    PhoneValidator phoneValidator = new PhoneValidator();
    PasswordChecker passwordChecker = new PasswordChecker();
    Boolean bool = false;

    @Autowired
    private VartotojasRepository repository;

    public List<Vartotojas> findAll() {
        return (List<Vartotojas>) repository.findAll();
    }

    public Vartotojas findById(int id) {
        return repository.findById(id).get();
    }

    public void update (Vartotojas d) {

        int errorCode = 0;

        bool = emailValidator.isValid(d.getEmail());// checkTLD was returning false when should be true, was missing a not symbol ( ! )
        if(!bool){
            errorCode = 1;
            System.out.println("Error Code = "+ errorCode +" EmailValidator failed");
        }
        bool = phoneValidator.isValid(d.getTelefonoNumeris());// checkOnlyNumbers fails with +370 prefix
        if(!bool){
            errorCode = 2;
            System.out.println("Error Code = "+ errorCode +" PhoneValidator failed");
        }
        bool = passwordChecker.isValid(d.getSlaptazodis());
        if(!bool){
            errorCode = 3;
            System.out.println("Error Code = "+ errorCode +" PasswordChecker failed");
        }
        if(errorCode == 0){
            repository.save(d);
        }
    }

    public Vartotojas add(Vartotojas d) {

        int errorCode = 0;

        bool = emailValidator.isValid(d.getEmail());
        if(!bool){
            errorCode = 1;
            System.out.println("Error Code = "+ errorCode +" EmailValidator failed");
        }
        bool = phoneValidator.isValid(d.getTelefonoNumeris());
        if(!bool){
            errorCode = 2;
            System.out.println("Error Code = "+ errorCode +" PhoneValidator failed");
        }
        bool = passwordChecker.isValid(d.getSlaptazodis());
        if(!bool){
            errorCode = 3;
            System.out.println("Error Code = "+ errorCode +" PasswordChecker failed");
        }

        if(errorCode == 0){
            return repository.save(d);
        }
        return new Vartotojas("","","","","","");
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
