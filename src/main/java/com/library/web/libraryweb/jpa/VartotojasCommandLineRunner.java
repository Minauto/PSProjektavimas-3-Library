package com.library.web.libraryweb.jpa;

import com.library.web.libraryweb.model.Vartotojas;
import com.library.web.libraryweb.repository.VartotojasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner is invoked on application start

@Component
public class VartotojasCommandLineRunner implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(VartotojasCommandLineRunner.class);

    @Autowired
    private VartotojasRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("~~~~~~ DarbuotojasCommandLineRunner ~~~~~~");
        repository.save(new Vartotojas("Jonas", "Jonaitis","861234567", "jonas@gmail.com","namas 7", "afgcd*K"));
        repository.save(new Vartotojas("Petras", "Algirdaitis","867654321", "petras@gmail.com","kiemas 2", "*46ascaH"));
        repository.save(new Vartotojas("Algirdas", "Petrauskas","861212312", "algirdaitis@gmail.com","gatve 3", "lajkVC$"));


        for (Vartotojas o : repository.findAll()) {
            log.info(o.toString());
        }
    }

}
