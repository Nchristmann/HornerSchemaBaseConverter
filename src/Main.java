import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // find the length of the number ?
    // iterate through the string (number)
    // convert any "letter numbers" into a usable int by casting it as an int (subsequnetly getting its ascii) and -55 to get desired value as used by hex
    // multiply each digit by the base
    // add to next digit
    public static int changeCharToInt(char digit) throws Exception {
        if (Character.isDigit(digit) ) { //if digit is a number just return it as an int
            return Character.getNumericValue(digit);
        }else if (Character.isUpperCase(digit)){ //if digit is a letter change letter to int (cast as int subtract 55 from ascii to get desired value
            return (int) digit - 55;
        }else { //Throws an exception since an unexpected character was entered
            throw new Exception("Unexpected special character");
        } //End if
    } //End Method changeCharToInt
    public static char changeIntToChar(int x){
        if (x < 10){
            return Character.forDigit(x, 10);
        }else{
            return (char) (x + 55);
        }//End if
    } //End Method changeIntToChar
    public static int changeToDecimal(String numberString, int base) throws Exception {
        int newNum = 0;
        for (int i = 0; i < numberString.length(); i++) {
            newNum = newNum * base;
            newNum = newNum + changeCharToInt(numberString.charAt(i));
        } //End of for
        System.out.println("The number in the decimal system is: " + newNum);
        return newNum;
    }//End Method changeToDecimal
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want to convert: "); //Needs to be a string, so I can add numbers over base 10 i.e. F for 15
        String numberstrToConvert = sc.nextLine();
        System.out.print("Enter the numbers current base: ");
        int currentBase = sc.nextInt();
        //Should check that no number is used that is greater than the base - user error
        System.out.print("Enter the base you want the number to be: ");
        //TODO create own method for the decimal to base conversion
        int baseConv = sc.nextInt();
        int quotient = changeToDecimal(numberstrToConvert, currentBase);
        int rest = 0;
        ArrayList<Character> convertedNum = new ArrayList<>();
        while(!(quotient == 0)){
            if (quotient < 0){
                throw new Exception("Error");
            } else{
                rest = quotient % baseConv;
                convertedNum.add(0,changeIntToChar(rest));
                quotient = quotient / baseConv;
            }//end if
            //change to decimal
            //divide to closest whole number
            //add the rest to a list or str
            //take current division solution and repeat
        }//End while
        System.out.print("Your number: " + numberstrToConvert + " from base: " + currentBase + " is: ");
        Arrays.stream(convertedNum.toArray()).forEach(System.out::print);
        System.out.print(" in the base: " + baseConv + "\n");
    } //End Method Main
} //End Class Main

