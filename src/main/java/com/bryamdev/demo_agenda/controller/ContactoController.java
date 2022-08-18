package com.bryamdev.demo_agenda.controller;

import com.bryamdev.demo_agenda.model.Contacto;
import com.bryamdev.demo_agenda.repo.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping("")
    public String index(Model model) {
        List<Contacto> contactos = contactoRepository.findAll();
        model.addAttribute("contactos", contactos);
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    @PostMapping("/nuevo")
    public String crear(@Validated Contacto contacto, BindingResult bindingResult, Model model, RedirectAttributes ra) {
        if(bindingResult.hasErrors()){
            model.addAttribute("contacto", contacto);
            return "nuevo";
        }
        contactoRepository.save(contacto);
        ra.addFlashAttribute("msgExito", "El contacto a sido creado correctamente");
        return "redirect:/";
    }
}
