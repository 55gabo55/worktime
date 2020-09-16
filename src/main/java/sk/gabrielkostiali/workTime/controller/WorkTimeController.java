package sk.gabrielkostiali.workTime.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sk.gabrielkostiali.workTime.mappers.EmployeeMapper;
import sk.gabrielkostiali.workTime.mappers.WorkTimeMapper;
import sk.gabrielkostiali.workTime.mappers.WorkTimeRegisterMapper;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.WorkTimeRegister;
import sk.gabrielkostiali.workTime.model.dto.EmployeeDto;
import sk.gabrielkostiali.workTime.model.dto.ViewForm;
import sk.gabrielkostiali.workTime.service.api.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkTimeController {

    private final EmployeeService employeeService;
    private Employee chosenEmployee;

    public WorkTimeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/showTime")
    public String showTime(Model model) {
        System.out.println("fsadf " + chosenEmployee.getWorkTimes().size());
        model.addAttribute("workTimes", chosenEmployee.getWorkTimes());

        return "showTime";
    }

    @GetMapping("/showTimeForm")
    public String showTimeForm(Model model) {
        ViewForm viewForm = new ViewForm();
        model.addAttribute("viewForm", viewForm);


        List<EmployeeDto> employees = employeeService.getEmployees();
        model.addAttribute("listEmployee", employees);

        return "showTime_form";
    }

    @PostMapping("/showTime")
    public String showTimePost(@ModelAttribute("viewForm") ViewForm viewForm ) {
        chosenEmployee = employeeService.getEmployeeView(viewForm);
        return "redirect:/showTime";
    }


    @GetMapping("/registerEmployee")
    public String registerEmployee(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);

        return "registerEmployee_form";
    }

    @PostMapping("/registerEmployee")
    public String submitEmployeeForm(@ModelAttribute("employeeDto") EmployeeDto employeeDto ) {
        System.out.println(employeeDto);
        employeeService.addEmployee(EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto));
        return "index";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        WorkTimeRegister workTimeRegister = new WorkTimeRegister();
        model.addAttribute("workTimeRegister", workTimeRegister);

        List<EmployeeDto> employees = employeeService.getEmployees();
        model.addAttribute("listEmployee", employees);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("workTimeRegister") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                     WorkTimeRegister workTimeRegister ) {
        System.out.println(workTimeRegister);
        WorkTimeRegisterMapper workTimeRegisterMapper = new WorkTimeRegisterMapper(employeeService);
        WorkTime workTime = workTimeRegisterMapper.toWorkTime(workTimeRegister);
        employeeService.addWorkTime(workTime, workTime.getEmployee().getId());
        return "index";
    }
}
