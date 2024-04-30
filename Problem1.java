class Problem1 extends ConsoleProgram {

  /**
  * Problem1.java prompts the user for their first name, last name, student
  * number, and password. It will then display their username and password
  * validation status.
  * @author: E.Fung 
  */

  
  
  public void run() {

    // Initializing input variables
    String strFirstInput, strLastInput, strNumInput, strPasswordInput;

    // Gathering User Inputs
    System.out.println("***** Student Account Registration *****");
    strFirstInput = readLine("Enter your first name: ");
    strLastInput = readLine("Enter your last name: ");
    strNumInput = readLine("Enter your student number: ");
    strPasswordInput = readLine("Enter a new password: ");
    System.out.println("");

    // Outputting results of methods
    System.out.println("Your username is: " + createUserName(strFirstInput, strLastInput, strNumInput));
    System.out.println("Valid password: " + validatePassword(strPasswordInput));
  }


  /**
  * Given the first name, last name, and student number generates a username
  *
  * @param strFirst  string of first name
  * @param strLast  string of last name
  * @param strNum  string of student number
  * @return string of generated username
  *
  */

  public String createUserName(String strFirst, String strLast, String strNum){
    // Initializing variables
    String strUsername = "";
    int intLastNameIndex = 4;

    // Checks if last name has four or more characters
    if (strLast.length() < 4){
      // If last name has 4 or less characters, use full last name
      intLastNameIndex = strLast.length();
    }
    try{
      // Creating username
      strUsername = Character.toUpperCase(strFirst.charAt(0)) + strLast.substring(0, intLastNameIndex).toLowerCase() + strNum.substring(strNum.length() - 3, strNum.length());
      return strUsername;
    }
    catch (IndexOutOfBoundsException e){
      // If index of string is empty, throw illegal argument exception
      throw new IllegalArgumentException("incorrect parameter(s)");
    }
  }
  /**
  * Validates password by checking three things: 
  * Password must consist of only letter and digit characters,
  * has at least one uppercase letter,
  * and at least 7 characters long.
  * this method will throw an illegal argument exception if the length condition is not met
  *
  * @param strPassword string of new password
  * @return boolean of password validation
  *
  */
  public boolean validatePassword(String strPassword){
    // Initializing variable
    int intUpperCount = 0;

    // Checking password length condition (must be larger or equal to 7)
    if (strPassword.length() < 7){
      throw new IllegalArgumentException("incorrect parameter(s)");
    }
    
    // Checks through every character in password string
    for (int i = 0; i < strPassword.length(); i++){
      // Checking if password characters are just letters and digits
      if (!Character.isDigit(strPassword.charAt(i)) && !Character.isAlphabetic(strPassword.charAt(i))){
        return false;
      }

      // Checks every character and stores how many upper cased characters are in password
      if (Character.isUpperCase(strPassword.charAt(i))){
        intUpperCount++;
      }
    }
    // Checking if there is at least one upper case character
    if (intUpperCount < 1){
      return false;
    }

    // returns true if it passess all the above conditions
    return true;
  }
}