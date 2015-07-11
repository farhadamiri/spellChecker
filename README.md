# spellChecker
Automatic spell checker is used to analyze documents and find words that might be misspelled. 
This program works by comparing each word in the document to a large dictionary of words. 
If the word is not found in the dictionary, it is flagged as potentially incorrect. 
It is required to find the total number of words, number of correctly spelled words,
number of incorrectly spelled words, total number of recursive steps, average number of recursive
steps for correctly spelled words, and the average number of recursive steps for incorrectly 
spelled words. On the other hand, we suppose to create our own MyLinkedList to design this program, 
so we should use an Array of MyLinkedList of 26 (alphabet number) to import the number of the alphabet 
from a to z. 
In my methodology, there are 5 methods (Reading file of the dictionary, Search word method, Read Oliver text file method,
Main method, result method) which are responsible for separate individual tasks. 
For instance; the program will read and store the dictionary text file into array of MyLinkedList 
by using read file dictionary method. Then the Boolean linear search method will search for the words and 
analyze with the Oliver text file method. The main method will be implemented, which will call all methods and 
finally we will see the program result by the result method. The Program result shows us comprehensive 
information about the text file which helps us to find text misspelled errors and how the MyLinkedList compared words. 
In summary, we import our dictionary text file and compare it with misspelled text files that
are found in our text file. In addition, the program counts the number of incorrectly spelled words;
total number of recursive steps for all incorrectly spelled words, and output these counters along with
the average number of recursive steps per incorrectly spelled words.
