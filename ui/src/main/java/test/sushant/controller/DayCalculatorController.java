package test.sushant.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import test.sushant.test.sushant.dto.RequestObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Controller
public class DayCalculatorController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${custom.error.message}")
    private String errorMessage;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @PostMapping("/calculate")
    public String resultPage(@ModelAttribute RequestObject requestObject, Model model) {
        if(requestObject == null || (requestObject.getStartDate().isEmpty() && requestObject.getEndDate().isEmpty())) {
            model.addAttribute("errorMessage", "request is empty!");
            return "error";
        }
        if(requestObject.getStartDate().isEmpty()){
            model.addAttribute("errorMessage", "Start Date is empty!");
            return "error";
        }
        if(requestObject.getEndDate().isEmpty()) {
            model.addAttribute("errorMessage", "End Date is empty!");
            return "error";
        }

        try {
            Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(requestObject.getStartDate());
            Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(requestObject.getEndDate());
            if(dateStart.after(dateEnd)) {
                model.addAttribute("errorMessage", errorMessage);
                return "error";
            }
            long diffInMillies = Math.abs(dateEnd.getTime() - dateStart.getTime());
            long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            model.addAttribute("days", days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "result";
    }
}
