package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarService;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(HttpServletRequest request, Model model) {
        String count = request.getParameter("count");
        try {
            model.addAttribute("carList", carService.showCars(count));
        } catch (IOException e) {
            return "fail";
        }
        return "cars";
    }


}
