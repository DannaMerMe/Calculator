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
    public int getDivision(@RequestParam int dividend, @RequestParam  int divider ) {
     logger.info("etDivision called");
        return calculatorService.division(dividend, divider);
    }

    @GetMapping("/root")
    public double getSquareRoot(@RequestParam int number) {
     logger.info("getSqueareRoot called");
       return calculatorService.squareRoot(number);
    }

    @GetMapping("/loga")
    public double getLogatihm(@RequestParam int number) {
     logger.info("getLogatihm called");
       return calculatorService.logarithm(number);
    }
    @GetMapping("/power")
    public double getPower(@RequestParam int base, @RequestParam int exponent) {
      logger.info("getPower called");
      return calculatorService.power(base, exponent);
    }
    

}
