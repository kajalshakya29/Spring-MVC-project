package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.EmployeeService;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping("/list")
    public ModelAndView listEmployees() {
        List<Employee> list = service.getEmployees();
        return new ModelAndView("employee-list", "employees", list);
    }
    @GetMapping("/add")
    public String showAddForm() {
        return "employee-add";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee e) {
        service.addEmployee(e);
        return "redirect:/list";
    }
    @GetMapping("/update/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Employee e = service.getEmployeeById(id);
        return new ModelAndView("employee-update", "employee", e);
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Employee e) {
        service.updateEmployee(e);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEmployee(id);
        return "redirect:/list";
    }
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        Employee e = service.getEmployeeById(id);
        return new ModelAndView("employee-view", "employee", e);
    }
}
