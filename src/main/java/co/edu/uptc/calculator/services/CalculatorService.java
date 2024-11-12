package co.edu.uptc.calculator.services;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CalculatorService {
     private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);



    private String nameHost(){
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return inetAddress.getHostName();
    }

    public int division(int number1, int number2){
        String hostName= nameHost();
        logger.info("Host {} - Calculating division of {} by {}", hostName, number1, number2);
        if(number2==0){
            logger.error("Host {} - Division by zero attempted!", hostName);
            throw new ArithmeticException("Cannot divide by zero");
        }
        
        int result = number1/number2;
        return result;
    }

    public double squareRoot(int number){
       String hostName= nameHost();
        if(number < 0){
           logger.error("Host {} - Negative number for square root error!", hostName);
           throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        double result= Math.sqrt(number);
        return result;
    }

    public double logarithm(int number){
        String hostName = nameHost();
        if (number <= 0) {
            logger.error("Host {} - Non-positive number for logarithm error!", hostName);
            throw new IllegalArgumentException("Number must be positive for logarithm calculation");
        }
        double result = Math.log(number);
        return result;
    }

    public double power(int base, int exponent){
        String hostName = nameHost();
        if (base == 0 && exponent < 0) {
            logger.error("Host {} - Non-positive number for power error!", hostName);
            throw new ArithmeticException("Zero cannot be raised to a negative exponent");
        }
        double result= Math.pow(base, exponent);
        return result;
    }

}

