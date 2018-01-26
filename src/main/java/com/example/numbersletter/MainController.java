package com.example.numbersletter;
import com.fasterxml.jackson.core.io.NumberInput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

import static java.lang.Character.getNumericValue;

@RestController
public class MainController {

    @RequestMapping("/")
    public String showIndex() {
        Scanner numberInput = new Scanner(System.in);
        String number = numberInput.nextLine();
        int numberLength = number.length();
        String[] place = {"Million", "Hundred Thousand","Thousand","Thousand", "Hundred","", ""};
        String[] ones = {" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {" ", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {" ", "Ten" , "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        for(int n=0; n < numberLength; n++){
            int numberValue = Character.getNumericValue(number.charAt(n));
            if (n == numberLength-2) {
                if (numberValue == 1) {
                    System.out.println(teens[numberValue-1]);
                    break;
                } else if (numberValue == 0) {
                    System.out.println("0");
                } else {
                   System.out.println(tens[numberValue]);
                }
            }
            else{
                System.out.println(ones[numberValue] + " " + place[((numberLength + (n)))]);
            }
        }
    return null;
    }
}
