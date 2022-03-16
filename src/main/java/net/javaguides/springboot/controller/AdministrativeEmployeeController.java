package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.AdministrativeEmployee;
import net.javaguides.springboot.service.AdministrativeEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AdministrativeEmployeeController {

    @Autowired
    private AdministrativeEmployeeService administrativeEmployeeService;

    @GetMapping("/administrativeemployees")
    public String administrativeemployees(Model model) {
        List<AdministrativeEmployee> administrativeEmployees = administrativeEmployeeService.getAllAdministrativeEmployees();
        model.addAttribute("administrativeemployees", administrativeEmployees);
        return "administrativeemployees";
    }


    @GetMapping("/showNewAdministrativeEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        AdministrativeEmployee administrativeEmployee = new AdministrativeEmployee();
        model.addAttribute("administrativeemployee", administrativeEmployee);
        return "new_administrativeemployee";
    }

    @PostMapping("/saveAdministrativeEmployee")
    public String saveAdministrativeEmployee(@ModelAttribute("administrativeemployee") AdministrativeEmployee administrativeEmployee) {
        administrativeEmployeeService.saveAdministrativeEmployee(administrativeEmployee);
        return "redirect:administrativeemployees";
    }

}

