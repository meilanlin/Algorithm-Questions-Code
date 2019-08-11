/*
Given a string, remove all leading/trailing/duplicated empty spaces.

Assumptions:
The given string is not null.

Examples:
¡°  a¡± --> ¡°a¡±
¡°   I     love MTV ¡± --> ¡°I love MTV¡±

https://app.laicode.io/app/problem/281
 */
public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here
    if(input == null || input.length() == 0) return input;
    char[] array = input.toCharArray();
    int i = 0;
    int j = 0;
    while(j < array.length){
      if(array[j] != ' '){
        Character temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j++;
      }else{
        if(i == 0){
          j++;
        }else{
          if(array[i - 1] != ' '){
            array[i] = ' ';
            i++;
            j++;
          }else{
            j++;
          }
        }
      }
    }
    if(i > 0 && array[i - 1] == ' ') i = i - 1;
    return new String(array, 0, i);
  }
}
