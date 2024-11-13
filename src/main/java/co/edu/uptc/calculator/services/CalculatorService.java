package co.edu.uptc.calculator.services;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public int division(int number1, int number2) {
        String hostName = nameHost();
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try {
            int result = number1 / number2;
            logger.info("Host {} - Calculating division of {} by {}", hostName, number1, number2);
            return result;
        } catch (ArithmeticException e) {
            logger.error("Host {} - Error at {} while calculating division: {}", hostName, currentTime, e.getMessage());
            throw e; 
        }
    }

    public double squareRoot(int number) {
        String hostName = nameHost();
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
            }
            logger.info("Host {} - Calculating square root of {}", hostName, number);
            return Math.sqrt(number);
        } catch (Exception e) {
            logger.error("Host {} - Error at {} while calculating square root: {}", hostName, currentTime, e.getMessage());
            throw e;
        }
    }

    public double logarithm(int number) {
        String hostName = nameHost();
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try {
            if (number <= 0) {
                throw new IllegalArgumentException("Cannot calculate logarithm of zero or a negative number.");
            }
            logger.info("Host {} - Calculating logarithm of {}", hostName, number);
            return Math.log(number);
        } catch (Exception e) {
            logger.error("Host {} - Error at {} while calculating logarithm: {}", hostName, currentTime, e.getMessage());
            throw e;
        }
    }


    public double power(int base, int exponent) {
        String hostName = nameHost();
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try {
            if (base == 0 && exponent < 0) {
                throw new IllegalArgumentException("Cannot calculate power with base 0 and a negative exponent.");
            }
            logger.info("Host {} - Calculating power of {} to the exponent {}", hostName, base, exponent);
            return Math.pow(base, exponent);
        } catch (Exception e) {
            logger.error("Host {} - Error at {} while calculating power: {}", hostName, currentTime, e.getMessage());
            throw e;
        }
    }
    
    
}

