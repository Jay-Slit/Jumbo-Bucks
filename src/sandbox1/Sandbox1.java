/*
 * Author: Cameron Justice
 * Program Title: 
 * Program Summary:
 */
package sandbox1;

//Imports
import java.util.Random;
import java.util.Scanner;

public class Sandbox1 {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Junior Jumbo Bucks!\n" +
                           "Do you need to know the rules? Y/n");
        if("Y".equals(input.next().toUpperCase()))
            printRules();
        
        int serialNumber = rand.nextInt(9 - 1 + 1) + 1;
        
        System.out.println("Your serial number is: " + serialNumber);
        
        System.out.println("Press ENTER to scratch the next number!");
        
        for(int i = 1; i < 7; i++){
            String lottoString = "";
            int lotto = getLotto(serialNumber);
            if(lotto == 10){
                lottoString = Integer.toString(lotto);
                lottoString = "JUMBO";
            }
            if(input.nextLine().isEmpty())
                if(lottoString == "")
                    System.out.println("#" + i + " is: " + lotto + " Prize: $" + getPrize());
                else
                    System.out.println("#" + i + " is: " + lottoString + " Prize: $" + getPrize());
        }
    }
    
    public static int getLotto(int serialNumber){
        Random rand = new Random();
        int lotto = 1;
        
        lotto = rand.nextInt(20 - 1 + 1) + 1;
        
        if(lotto > 10){
            if(lotto - 10 != serialNumber)
                lotto -= 10;
            else{
                if(rand.nextBoolean() == true)
                    lotto -= 10;
                else
                    if(lotto - 11 != 0)
                        lotto -= 11;
                    else
                        lotto -= 9;
            }
                         
        }
        
        if(lotto == 10){
            if(rand.nextBoolean())
                if(rand.nextBoolean())
                    if(rand.nextBoolean())
                        if(rand.nextBoolean())
                            if(rand.nextBoolean())
                                return lotto;
            else
                if(lotto - 1 == serialNumber)
                    lotto -= 2;
                else
                    lotto -= 1;
        }
        
        if(lotto == serialNumber)
            if(rand.nextBoolean()){
                return lotto;
            }
            else{
                if(lotto + 1 != 10)
                    lotto += 1;
            }
                
        return lotto;
    }
    
    public static int getPrize(){
        Random rand = new Random();
        int prize = 1;
        
        int prizeChance  = rand.nextInt(100 - 1 + 1) + 1;
        
        if(prizeChance < 90){
            prizeChance = rand.nextInt(80 - 1 + 1) + 1;
            if(prizeChance < 80){
                prizeChance = rand.nextInt(60 - 1 + 1) + 1;
                if(prizeChance < 40){
                    prizeChance = rand.nextInt(40 - 1 + 1) + 1;
                    if(prizeChance < 20){
                        prizeChance = rand.nextInt(20 - 1 + 1) + 1;
                        if(prizeChance < 10){
                            prizeChance = rand.nextInt(10 - 1 + 1) + 1;
                            if(prizeChance < 5){
                                prize = prizeChance * 1;
                            }
                            else
                                prize = rand.nextInt((prizeChance * 10 + 1) - 1 + 1) + 1;
                        }
                        else
                            prize = rand.nextInt((prizeChance * 10 + 1) - 1 + 1) + 1;
                    }
                    else
                        prize = rand.nextInt((prizeChance * 10 + 1) - 1 + 1) + 1;
                }
                else
                    prize = rand.nextInt((prizeChance * 50 + 1) - 1 + 1) + 1;
            }
            else
                prize = rand.nextInt((prizeChance * 50 + 1) - 1 + 1) + 1;
        }
        else
            prize = rand.nextInt((prizeChance * 100 + 1) - 1 + 1) + 1;
        
        return prize;
    }
    
    public static void printRules(){
        System.out.println("First you'll be given a serial number. Reveal your"+
                           " 6 numbers and if any match your serial number, win"+
                           " the prize for that number. If any numbers are "+
                           "replaced by JUMBO; win double that prize!");
    }
}
