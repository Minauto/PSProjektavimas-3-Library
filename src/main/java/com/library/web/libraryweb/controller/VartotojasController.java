package com.library.web.libraryweb.controller;

import com.library.web.libraryweb.model.Vartotojas;
import com.library.web.libraryweb.service.VartotojasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VartotojasController {

    @Autowired
    VartotojasService service;

    @GetMapping("/")
    public String homePageRedirect() {
        return "redirect:/list-vartotojai";
    }

    // GET request
    // localhost:8080/list-vartotojai
    @GetMapping("/list-vartotojai")
    public String showAll(ModelMap model) {
        model.put("vartotojai", service.findAll());
        return "list-vartotojai";
    }

    @GetMapping("/add-vartotojas")
    public String showAddPage(ModelMap model) {
        model.addAttribute("vartotojas", new Vartotojas("", "","", "","", ""));
        return "vartotojas";
    }

    @PostMapping("/add-vartotojas")
    public String add(ModelMap model, @ModelAttribute("vartotojas") Vartotojas vr, BindingResult result) {
        if(result.hasErrors()) {
            return "vartotojas";
        }
        service.add(vr);
        return "redirect:/list-vartotojai";
    }

    @GetMapping("/vartotojas/{vartotojasId}")
    public String getVartotojas(ModelMap model,@PathVariable int vartotojasId) {
        model.addAttribute("vartotojas", service.findById(vartotojasId));
        return "vartotojas-show";
    }

    @GetMapping("/update-vartotojas/{vartotojasId}")
    public String showUpdatePage(ModelMap model, @PathVariable int vartotojasId) {
        model.addAttribute("vartotojas", service.findById(vartotojasId));
        return "vartotojas";
    }

    @PostMapping("/update-vartotojas/{vartotojasId}")
    public String update(ModelMap model, @ModelAttribute("darbuotojas") Vartotojas vr, BindingResult result) {
        if(result.hasErrors()) {
            return "vartotojas";
        }
        service.update(vr);
        return "redirect:/list-vartotojai";
    }

    @GetMapping("/delete-vartotojas/{vartotojasId}")
    public String delete(@PathVariable int vartotojasId) {
        service.deleteById(vartotojasId);
        return "redirect:/list-vartotojai";
    }
}
