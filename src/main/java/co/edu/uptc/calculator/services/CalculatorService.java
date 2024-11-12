package co.edu.uptc.calculator.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.calculator.exception.InvalidRangeException;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
@Service
public class CalculatorService {
     private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    @Value("${animal.file.path}")
    private String filePath;


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
        int result = number1/number2;
        return result;
    }

    public double squareRoot(int number){
        double result= Math.sqrt(number);
        return result;
    }

    public double logarithm(int number){
        double result = Math.log(number);
        return result;
    }

}

