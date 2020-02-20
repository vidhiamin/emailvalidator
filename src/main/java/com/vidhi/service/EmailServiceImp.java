package com.vidhi.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Component("emailQualifier")
public class EmailServiceImp implements EmailService {


    //FindUniqueEmailAddress method will validate all comma separated email addresses and returns number of unique email addresses
    @Override
    public int findUniqueEmailAddress(String email) {
        //Split email list by "," and store it in the array
        String[] emailList = email.split(",");
        //Returns number of unique email addresses
        return getUniqueEmailAddressesCount(emailList);
    }

    //Method for counting unique email addresses
    public int getUniqueEmailAddressesCount(String[] emailList){
        final int LOCAL_PART_INDEX = 0;
        final int DOMAIN_PART_INDEX = 1;

        //Create a emailset to identify unique email addresses
        Set<String> emailSet = new HashSet<>();

        //Iterate over the input email list
        for(String email : emailList){

            //Remove extra spaces(before and after email) and convert into lowercase
            email = email.trim().toLowerCase();
            if(validateEmailAddress(email)){

                //Split the string by "@" and store it into splitString
                String[] splitString = email.split("@",2);

                //Remove all "." from the local part of an email
                String finalLocalPart = splitString[LOCAL_PART_INDEX].replaceAll("\\.", "");

                //Remove all characters from first occurrence of "+" in local part of an email
                finalLocalPart = finalLocalPart.replaceAll("\\+.*", "");

                //Validating local part of an email length greater than 5
                if(finalLocalPart.length()>5){
                    String finalEmailAddress = finalLocalPart + "@" + splitString[DOMAIN_PART_INDEX];
                    //Add resultant email address into the emailset
                    emailSet.add(finalEmailAddress);
                }
            }
        }
        return emailSet.size();
    }

    //method for email address validation
    public boolean validateEmailAddress(String email){
        /* validEmailRegex checks the following constraints for overall email validation
            1. length should be between 6 to 36 included
            2. Username only contains alphanumeric, digits and "."
            3. Username does not starts and ends with "."
            4. Can not accept the consecutive "."
            5. Email accepts either gmail.com or googlemail.com after "@"
            6. Email address must have only one "@"
        */
        String validEmailRegex = "^[a-z0-9](\\.?[a-z0-9\\+]){5,35}@g(oogle)?mail\\.com$";
        /* invalidNumberRegex checks on the following constraints for numeric email validation
            1. if username contains only digits, then length of username should not be more than 7
            2. if username contains 8 or more numbers then it must include at least one alphabet for valid email address
       */
        String invalidNumberRegex = "^[0-9]{8,}@g(oogle)?mail\\.com$";

        //pattern will compiles the regex
        Pattern validEmailRegexPattern = Pattern.compile(validEmailRegex);
        Pattern invalidNumberRegexPattern= Pattern.compile(invalidNumberRegex);

        //matcher will match the regex with the email address
        Matcher validEmailRegexMatcher = validEmailRegexPattern.matcher(email);
        Matcher invalidNumberRegexMatcher = invalidNumberRegexPattern.matcher(email);

        if(validEmailRegexMatcher.matches()){
            if(invalidNumberRegexMatcher.matches()){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

}
