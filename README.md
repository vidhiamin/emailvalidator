# Email Validator Using Spring Boot
## Problem Statement 

Accept a list of email addresses and return an integer indicating the number of unique email addresses.
Where "unique" email addresses means they will be delivered to the same account using Gmail account matching. 

 
**Following are the constraints that I handled in my project-**
#### Character length
- Choose a username 6–30 characters long. Your username can be any combination of letters, numbers, or symbols.

#### Special characters
- Usernames can contain letters (a-z), numbers (0-9), and periods (.).
- Usernames cannot contain an ampersand (&), equals sign (=), underscore (_), apostrophe ('), dash (-), plus sign (+), comma (,), brackets (<,>), or more than one period (.) in a row.
- Usernames can begin or end with non-alphanumeric characters except periods (.).


**Following are steps to create and run an executable jar-**

1) Write the following command in terminal at project folder level for creating the Jar- 

    `$mvn clean install`

2) To run a jar file use the following command

    `$java -jar target/jarname.jar`
