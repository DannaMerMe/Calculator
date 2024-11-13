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
   public int getDivision(@RequestParam int dividend, @RequestParam int divider) {
      logger.info("getDivision called");
      try {
          return calculatorService.division(dividend, divider);
      } catch (Exception e) {
          logger.error("Error during getDivision: {}", e.getMessage());
          throw e; 
      }
  }

    @GetMapping("/root")
    public double getSquareRoot(@RequestParam int number) {
      logger.info("getSquareRoot called");
      try {
          return calculatorService.squareRoot(number);
      } catch (Exception e) {
          logger.error("Error during getSquareRoot: {}", e.getMessage());
          throw e;
      }
  }

    @GetMapping("/log")
    public double getLogatihm(@RequestParam int number) {
      logger.info("getLogarithm called");
      try {
          return calculatorService.logarithm(number);
      } catch (Exception e) {
          logger.error("Error during getLogarithm: {}", e.getMessage());
          throw e;
      }
    }
    @GetMapping("/power")
    public double getPower(@RequestParam int base, @RequestParam int exponent) {
      logger.info("getPower called");
      try {
          return calculatorService.power(base, exponent);
      } catch (Exception e) {
          logger.error("Error during getPower: {}", e.getMessage());
          throw e;
      }
    }
    

}
