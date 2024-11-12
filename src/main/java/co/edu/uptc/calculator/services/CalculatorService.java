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
        int result = number1/number2;
        logger.info("Host {} - Calculating division of {} by {}", hostName, number1, number2);
        return result;
    }

    public double squareRoot(int number){
       String hostName= nameHost();
       logger.info("Calculating square root",hostName,number);
        double result= Math.sqrt(number);
        return result;
    }

    public double logarithm(int number){
        String hostName = nameHost();
        logger.info("Calculating logarithm",hostName,number);
        double result = Math.log(number);
        return result;
    }

    public double power(int base, int exponent){
        String hostName = nameHost();
        logger.info("Calculating power",hostName,exponent);
        double result= Math.pow(base, exponent);
        return result;
    }

}

