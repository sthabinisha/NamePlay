package nameplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamePlay {

    private static Pattern pattern = Pattern.compile("\\s{1,}");  // multiple spaces
    private static String finalStr = "";

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();

        String fullName = (firstName + " " + lastName);
        System.out.println("Name: " + fullName);




        countFullNameLength(fullName);
        //print length
        System.out.println("length( " + fullName + " ) :" + finalStr.length());

        String fNameLen = firstName.toString();
        
        String sNameLen = (lastName.toString());
     
        
        //compare length
        if (fNameLen.length() == sNameLen.length()) 
        {
            System.out.println("Status: Good one");
        }
        else 
        {
            System.out.println("Status: Not bad though");
        }
        
        Integer x = finalStr.length();
        String st = finalStr.substring(0, 1).toLowerCase().concat(finalStr.substring(1, x));//convert  first letter to lowercase
        System.out.println("Hungarian: " + st);
        
        try
        {
            countVowel(st);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    //findout fullname length
    public static void countFullNameLength(String fullName) {
        StringBuffer sb  = new StringBuffer();
        Matcher matcher = pattern.matcher(fullName);

        int startNext = 0;
        while (matcher.find(startNext))//find space
        {
        	
        sb.append(fullName.substring(startNext, matcher.start()));//append fullname without space
         
        startNext = matcher.end();

        }
        sb.append(fullName.substring(startNext));//fullname from initial to end string
        
        finalStr = sb.toString();

    }
//count vowel and remove the vowel with lowercase
    public static void countVowel(String hungarian) throws IOException {
        int vowels = 0;
        char ch;

        for (int i = 0; i < hungarian.length(); i++)
        {
            ch = hungarian.toLowerCase().charAt(i); //check for every alphabet

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
            {
                vowels++;
            }
        }

        System.out.println("Vowels : " + vowels);
        hungarian = hungarian.toLowerCase().replaceAll("[aeiou]", "");//convert to lowercase replacing vowel
        System.out.println("Vowelless:" + hungarian);
    }
}
