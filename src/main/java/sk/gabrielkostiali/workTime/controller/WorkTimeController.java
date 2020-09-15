package sk.gabrielkostiali.workTime.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sk.gabrielkostiali.workTime.model.WorkTime;

@Controller
public class WorkTimeController {

    @GetMapping("/register")
    public String showForm(Model model) {
        WorkTime workTime = new WorkTime();
        model.addAttribute("workTime", workTime);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("workTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                         WorkTime workTime ) {
        System.out.println(workTime);
        return "register_success";
    }
}
