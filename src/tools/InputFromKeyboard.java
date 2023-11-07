package tools;

import java.util.Scanner;

public class InputFromKeyboard {

    public static int inputNumberFromRange(Integer min, Integer max) {
        
        Scanner scanner = new Scanner(System.in);
        int number = min - 1;
        boolean isNumber = true;
        boolean repeat;
        do{
            try {
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                isNumber = false;
            }
            if(max == null ){
               if((number >= min) && isNumber){
                repeat = false; 
               }else{
                    System.out.printf("Enter number from next range: %d .. %d: ",min,max);
                    isNumber = true;
                    repeat = true;
                }
            }else{
                if((number >= min && number <= max) && isNumber){
                    repeat = false;
                }else{
                    System.out.printf("Enter number from next range: %d .. %d: ",min,max);
                    isNumber = true;
                    repeat = true;
                }
            }
        }while(repeat);
        return number;
    }
    
    
}