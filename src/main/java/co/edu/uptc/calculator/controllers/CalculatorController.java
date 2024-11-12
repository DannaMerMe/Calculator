package co.edu.uptc.calculator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.calculator.services.CalculatorService;




@RestController
@RequestMapping("/animal")
public class CalculatorController {

 private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

   @Autowired
    private CalculatorService calculatorService;

   @GetMapping("/division")
    public int getDivisio(@RequestParam int dividend, @RequestParam  int divider ) {
        return calculatorService.division(dividend, divider);
    }

    @GetMapping("/root")
    public double getSquareRoot(@RequestParam int number) {
       return calculatorService.squareRoot(number);
    }

    @GetMapping("loga")
    public double getMethodName(@RequestParam int number) {
       return calculatorService.logarithm(number);
    }

}
