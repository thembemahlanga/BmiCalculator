package bmicalculator;

import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        char repeat = 0;

        do {
        	
            //All Our code
            int unitChoice = getUnitChoice(scanner);
            double weight = (unitChoice == 1)? getValidInput(scanner,"Enter your weight in kilograms: ", 10, 600)
                    : getValidInput(scanner, "Enter your weight in pounds", 22, 1300);
            double height = (unitChoice == 1)? getValidInput(scanner, "Enter your height in meters:", 0.5, 2.5)
                    :getValidInput(scanner,"Enter your height in inches",20,100);
            double bmi = calculateBMI(unitChoice, weight,height);
            System.out.println("Your BMI is " + bmi+" category: "+displayCategory(bmi));
            
            repeat=askToRepeat(scanner);
            //repeat = askToRepeat(scanner);
            System.out.println();

        }while (repeat == 'Y' || repeat  =='y');

    }

    //Unit - Metric and Imperial
    public static int getUnitChoice(Scanner scanner){
        int choice;


        while(true) {
            System.out.println("Select a preferred unit:\n"
                    +"1.Metric (kg.m)\n"
                    +"2.Imperial(lbs,in)\n"
                    +"Please select either option 1 or option 2");

            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if(choice == 1 || choice==2){
                    break;
                }else {
                    System.out.println("Invalid choice. Please enter either 1 or 2");
                }
            }else {
                System.out.println("Invalid input. Please enter a number (1 or 2)");
                scanner.next();


            }
        }

        return choice;
    }
   
    public static double getValidInput(Scanner scanner, String prompt, double min, double max) {
        double value;
        while(true){
            System.out.println(prompt);
            if(scanner.hasNextDouble()){
                value=scanner.nextDouble();
                if(value>=min&& value<=max) {
                    break;

                }else {
                    System.out.printf("Please enter a value between %.1f and %.1f.\n",min,max);

                }

            }else{
                System.out.println("Invalid input.Please enter a value");
                scanner.next();

            }
        }


        return value;



    }


    public static double calculateBMI(int unitChoice, double weight, double height) {
        double totalBMI;

        if(unitChoice == 1) {
            totalBMI = weight / (height * height);
        }else{
            totalBMI = (703 * weight)/ (height * height);}

        return totalBMI;

    }
    public static String displayCategory(double bmi) {
    	if(bmi<16.0) {return "Severely Underweight";}
    	else if(bmi>=16&&bmi<=18.4) {return "Underweight";}
    	else if(bmi>=18&&bmi<=24.9) {return "Normal";}
    	else if(bmi>=25&&bmi<=29.9) {return "Overweight";}
    	else if(bmi>=30&&bmi<=34.9) {return "Moderately Obese";}
    	else if(bmi>=35&&bmi<=39.9) {return "Severely Obese";}
    	else {return "Morbidly Obese";}
    
    }
 
    public static char askToRepeat(Scanner scanner) {
        System.out.print("Would you like to calculate again? (Y/N): ");
        char answer;
        while (true) {
            String input = scanner.next();
            if (input.length() == 1) {
                answer = input.charAt(0);
                if (answer == 'Y' || answer == 'y' || answer == 'N' || answer == 'n') {
                    break;
                }
            }
            System.out.print("Invalid input. Please enter 'Y' or 'N': ");
        }
        return answer;
    }
    
    
    


}

		
		