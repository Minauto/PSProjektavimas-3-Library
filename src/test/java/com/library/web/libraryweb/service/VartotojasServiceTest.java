package com.library.web.libraryweb.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.library.web.libraryweb.model.Vartotojas;
import com.library.web.libraryweb.repository.VartotojasRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class VartotojasServiceTest {

    @Mock
    VartotojasRepository repository;

    @InjectMocks
    VartotojasService service;

    @DisplayName("Test Find All")
    @Test
    void testFindAll() {
        Vartotojas v = new Vartotojas( "", "","", "","", "");
        List<Vartotojas> vartotojai = new ArrayList<>();
        vartotojai.add(v);

        when(repository.findAll()).thenReturn(vartotojai);
        List<Vartotojas> found = service.findAll();

        verify(repository).findAll();
        assertEquals(1, found.size());
    }

    @Test
    void testFindById() {
        Vartotojas v = new Vartotojas( "", "","", "","", "");
        when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(v));

        Vartotojas found = service.findById(1);
        verify(repository).findById(Mockito.anyInt());
        assertNotNull(found);
    }

    @Test
    void testUpdate() {
        Vartotojas v = new Vartotojas( "", "","", "","", "");
        service.update(v);
        verify(repository).save(Mockito.any(Vartotojas.class));
    }

    @Test
    void testAdd() {
        Vartotojas v = new Vartotojas( "Jonas", "Petrauskas","861133444", "jonas.petrauskas@gmail.com","Upes gatve 4", "Slaptas$");
        when(repository.save(Mockito.any(Vartotojas.class))).thenReturn(v);

        Vartotojas added = service.add(v);
        verify(repository).save(Mockito.any(Vartotojas.class));
        assertNotNull(added);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1);
        verify(repository).deleteById(Mockito.anyInt());
    }

}
