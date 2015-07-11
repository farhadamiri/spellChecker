/**
 * Farhad Amiri date: 7/11/2015 class 202 Purpose: Spell Checking with
 * MyLinkedList.
 */
package assignmentfour;

import assignmentFour.MyLinkedList;
import java.io.*;
import java.util.Scanner;

/**
 * @require null
 * @ensure : declaring global variables
 */
public class assignment4 {

    long wrongwords = 0;
    long rightwords = 0;
    double cRec = 0;
    double iRec = 0;
    long totalwords = 0;

    public assignment4() {
    }// Default Constractor

    /**
     * @ require: null Ensure:out put the file/ calling method
     * @param args
     */
    public static void main(String[] args) {
        assignment4 object = new assignment4();
        MyLinkedList<String> list[] = new MyLinkedList[26];
        for (int i = 0; i < list.length; i++) {
            list[i] = new MyLinkedList();
        }// for
        object.readFile(list);
        object.readolive(list);
        object.results();
    }// main

    /**
     * @param list
     * @require: data text file
     * @ensure: open the file and import the file in MyLinkedList using the
     * ASCII key word
     * @ throws IO Exception
     */
    public void readFile(MyLinkedList<String> list[]) {

        File f = new File("random_dictionary.txt");
        try {
            Scanner input = new Scanner(f);
            while (input.hasNext()) {
                String line = input.nextLine().trim();
                // System.out.println( " all Word "+line);
                list[line.toLowerCase().charAt(0) - 97].add(0, line);
            }// while
            input.close();

        }//try
        catch (Exception e) {
        }// Catch
    }// readFile

    /**
     * @require: linear search
     * @ensure: search
     * @param list
     * @param line
     * @return true
     */
    public boolean SearchWord(MyLinkedList<String> list[], String line) {
        return list[line.toLowerCase().charAt(0) - 97].contains(line);

    }// linear search

    /**
     *
     * @require: read the text file and load the search method
     * @ensure: comparing dictionary with text file to find correct quantity of
     * total words, right words , incorrect words,average comparisons for
     * correct and incorrect, total of recursive step
     * @param list
     * @ throws IO Exception
     */
    public void readolive(MyLinkedList<String>[] list) {

        try {
            FileInputStream inf = new FileInputStream(new File("oliver.txt"));
            char let;
            String str = ""; //word to be processed
            int n = 0;
            while ((n = inf.read()) != -1) {
                let = (char) n;
                if (Character.isLetter(let)) {
                    str += Character.toLowerCase(let);

                }// if statement
                if ((Character.isWhitespace(let) || let == '-') && !str.isEmpty()) {
                    totalwords += 1;

                    if (SearchWord(list, str)) {
                        rightwords++;
                        //  System.out.println(str + " right words are ");
                        cRec += list[str.toLowerCase().charAt(0) - 97].getCompare();
                    } else {
                        //System.out.println(str + " misseplled");
                        wrongwords++;
                        iRec += list[str.toLowerCase().charAt(0) - 97].getCompare();
                    }// else statement 
                    str = "";

                }// if statement 
            }// while loop
            inf.close();

        } // try  
        catch (IOException ex) {
            System.out.println("Not read the olive");
        }// Exception 

    }// read Olive

    /**
     * @ require: null Ensure:out put the result for the users by correct
     * calculating
     */
    public void results() {
        System.out.println("Total words " + (totalwords));
        System.out.println("Number of right words are " + (rightwords));
        System.out.println("Number of Incorrect words are " + wrongwords);
        System.out.println("The average comparisons for words found:  " + cRec / rightwords);
        System.out.println("The average comparisons for words not found: " + iRec / wrongwords);
        int result = (int) (cRec + iRec);
        System.out.println("Total number of comparisons is:  " + (result));
    }// results

}// class
