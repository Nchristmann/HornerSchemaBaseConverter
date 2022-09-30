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
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want to convert: "); //Needs to be a string so I can add numbers over base 10 i.e. F for 15
        String numberstrToConvert = sc.nextLine();
        System.out.print("Enter the numbers current base: ");
        int currentBase = sc.nextInt();
        //Should check that no number is used that is greater than the base - user error
        /*
        //System.out.print("Enter the base you want the number to be: ");
        //int baseConv = sc.nextInt();
            Not sure it works the other way around
         */
        for (int i = 0, newNum = 0; i < numberstrToConvert.length(); i++) {
            newNum = newNum * currentBase;
            newNum = newNum + changeCharToInt(numberstrToConvert.charAt(i));
            System.out.println(newNum);
        } //End of for THIS IS THE HORNER SCHEMA
        //return newNum; //this goes nowhere right now
    } //End Method Main
} //End Class Main

