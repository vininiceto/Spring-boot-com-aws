package br.com.vininiceto.services;

import br.com.vininiceto.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OperationsService {

    public Double mathSum(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new ResourceNotFoundException("Please set a numeric value!");
        return convertToDouble(num1) + convertToDouble(num2);
    }

    public Double mathSub(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new ResourceNotFoundException("Please set a numeric value!");
        return convertToDouble(num1) - convertToDouble(num2);
    }

    public Double mathMult(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new ResourceNotFoundException("Please set a numeric value!");
        return convertToDouble(num1) * convertToDouble(num2);
    }

    public Double mathDiv(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new ResourceNotFoundException("Please set a numeric value!");
        return convertToDouble(num1) / convertToDouble(num2);
    }

    public Double mathMedia(String num1, String num2){
        if (!isNumeric(num1) || !isNumeric(num2)) throw new ResourceNotFoundException("Please set a numeric value!");
        return (convertToDouble(num1) + convertToDouble(num2)) / 2;
    }

    public Double mathSqu(String num1){
        if (!isNumeric(num1)) throw new ResourceNotFoundException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(num1));
    }

    public Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new ResourceNotFoundException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public Boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
