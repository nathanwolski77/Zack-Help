Word clouds of presidential debates
Goals
The goals of this project are to 1) gain experience using pieces of code written by someone other than yourself, 2) apply top-down design skills to break a large problem down into steps and helper methods, and 3) gain practice with file I/O, ArrayList, and methods.

Background
A common element seen on web pages these days are tag clouds, also referred to as word clouds. A tag cloud is a visual representation of frequency of words, where more frequent words are represented in larger font. One can obtain a more aesthetic result by using colors and placement. We are going to analyze a presidential debate transcript and create a tag cloud for each candidate based on the words they used, where the frequency of a word determines the size of the font to use for that word in the cloud.

This assignment is based on an assignment on word clouds by Sarah Diesburg at the University of Northern Iowa.

Tasks
Pair programming. Work in pairs using pair programming during the lab meetings and whenever you meet in person. You may work with anyone in the class. If necessary, review the guide to Pair Programming. Use hw1-Firstname1-Firstname2 as the name of the GitHub team, where you specify each of your first names.
Get the starter code from GitHub Classroom.
Your task is to define two classes: WordFrequency to represent a word and its frequency of occurrence and DebateWordCloud that analyzes a text file containing the transcript of a presidential debate and, with the help of some starter code, creates a web page with the word clouds.
The starter code includes a class named HtmlWordCloudPrinter that will convert WordFrequency objects to their HTML representation. The starter code provided has Java methods that you need to use in creating the HTML file. The code has comments to document each method; it is your responsibility to read the Javadoc comments to understand how to use it. Ask on Piazza if you need clarification. You do not need to understand all of the details, but you need to understand what each method does and how they work together.
The WordFrequency class
This class needs to represent a word and its current frequency. The word itself cannot be changed once it's been assigned a value, whereas, the current frequency can be changed by incrementing its value by one. That's the only change that can be made.
The class will implement the Comparable interface. This material will be covered in class. You can start reading about it on section 10.3
Define the following constructors and methods:
Two constructors to assign initial values. One constructor takes only a String parameter for the initial value of the word. The second constructor takes both a String parameter and an initial frequency. Both of these constructors need to throw an IllegalArgumentException if the String parameter is null or is the empty String or if the initial frequency is a negative number. 
getWord() and getFrequency(): Accessor methods for the word and its frequency. 
incrementFrequency() : increments by one the frequency of this word
toString() : Provides a String representation of this WordFrequency object. Use the format: word : frequency. For example: economy : 20
Override the equals() and compareTo() methods. It is necessary to implement the compareTo() method as part of implementing the Comparable interface. The equals() method is defined for completion; while there is a default method inherited from the Object class, it only compares object references.
The DebateWordCloud class
The DebateWordCloud Java class is where you will define the main() method and a group of methods that will do the bulk of the work. This includes scanning the content of the debate file, creating an ArrayList of WordFrequency objects, that is words spoken by a specified speaker and their frequency (except for stop words), identifying the 40 most frequently used words by that speaker, and using that information to call the HTMLWordCloudPrinter methods provided to create the word clouds. This class should include at least 3 methods (other than main()) to illustrate that you understand how to break large problems into small, manageable steps. Of course, you can create more than 3 new methods if you like.
Your program must take three arguments (i.e., via the String[] args parameter of the main() method) and an optional fourth argument:
the name of the debate text file
the identifier for the speaker that you wish to analyze. This string should be the exact identifier/name/label used in the debate transcript (without the colon. See below)
the name of the file with the stop words; the file has one word per line.
The optional fourth argument is the name of the output file. If this argument is not provided, then the default output file name is created from the speaker name, see examples below.
Examples:
If I invoke the program with arguments debateFiles/republican-debate2015Nov11.txt RUBIO stopwords.txt, since no name for the output file is provided, the program should produce a file named rubioWordCloud.html (that is, the speaker identifier in lower case, followed by WordCloud.html.
If I invoke the program with arguments debateFiles/dnc-2019debate3.txt SANDERS stopwords.txt 2019debate3-sanders.html, the program should produce a file named 2019debate3-sanders.html
Any other use of the program (fewer than 3 or more than 4 arguments) ends the program while providing instructions to the user on the appropriate way to run the program. That is, explain what the program does and what arguments it expects.
Do not assume the files exist and be sure to handle exceptions to have a good user experience. You may safely assume that if the first two files named exist, they will have appropriate content. That is, the debate file named contains transcript of a debate and the stop words file named has stop words.
When executed with appropriate arguments, your program needs to do the following.
print the top 40 words and their corresponding counts for the candidate specified as the argument.
Generate the HTML file with the word cloud of the top 40 words used in the debate by the speaker identified in the program argument.
Debate transcripts and stop words
You are provided with several debate files and a file of stop words in the starter code 

The debate files are transcripts of several debates including the first three democratic presidential debates and also debates from 2015. All these files are large as the debates are quite long. As you get started, I encourage you to create and use smaller files containing only the first few minutes of a debate. This will give you a better opportunity to troubleshoot problems as you complete the assignment.
A file with stop words that you will need to remove from consideration in processing the debate transcripts. Again, consider using a much smaller file.
Each of these files is explained below with more detail:

Each debate transcript is in a particular format. Each time one of the three participants speaks, that line is marked with the speaker's name followed by a colon (RUBIO:, SANDERS: or BOOKER:). Once encountered, all words following are attributed to that speaker until another label of a speaker occurs. Notice that this may not be for several lines.
File of stop words. Not all words are worth counting. In the context of analyzing speech, words such as ‘a’, ‘the’, ‘was’ have no value in trying to determine the content of the speech. Such words can be ignored from the analysis. A list of such words (commonly called stop words) is provided. Each line has a single word. No word in the stop word list should be counted in the tag cloud. This is the list distributed with MySQL 4.0.20 (a database software) with a few additions (mostly just duplication of contractions. That is both “can’t” and “cant” are now in the list)
Getting started
Understand the problem and break it down into smaller parts. Break down all the steps that need to be performed, and figure out which methods you need.
Parsing the debate file. You have to read in the file and separate the lines according to who said them, which is indicated in the transcript file with the name in all uppercase followed by a colon, e.g.: RUBIO: or SANDERS:. Once you see one of the speaker tags all lines/words belong to that speaker until you see another speaker tag.
You have to remove the stop words. You have two choices. Either do it as you are reading the debate or go back and remove them once you are done reading the entire debate. Each has advantages. Pick one and go with it.
Also remember to remove punctuation from words. Also, don't count the words describing the setting at the site of the debate; these are also in uppercase but are inside of parenthesis like (APPLAUSE) and (LAUGHTER). You can tell audience words apart from regular speech because they occur on separate lines and are surrounded by parenthesis.
Capital letters are a potential problem. If we aren't careful the word "Economic" at the start of a sentence will be counted separately from the word "economic" inside of a sentence. As these are the same word, your analysis must not be case sensitive. Beware when you decide to convert to lowercase letters since speakers are labeled with all uppercase and you may want/need to use this information.
Count the word frequency in the candidate's words. To complete this part, you're required to implement a class named WordFrequency that represents a word and an integer that represents the frequency of that word in a debate. You will need to update the frequency of a word as you encounter the same word later in the debate transcript.
Once you have built the ArrayList of the WordFrequency objects for the candidate in question, you need to work with the 40 most frequently spoken to create the word clouds. 
You also need to extract the largest frequency and the smallest frequency from the words in this top-40 as that information is needed by HTMLWordCloudPrinter
Finally, use the HTMLWordCloudPrinter starter code to generate the html file. You need to randomize the order of the words as they will appear in the word cloud since this will create a more aesthetically appealing word cloud.
Other requirements
You must not make changes to the HTMLWordCloudPrinter Java class provided.
Include in your submission the HTML files that result from executing your program on the presidential debates.
In addition to the source code required, include a contributions.txt file at the top level of the repository. This is a plain text file where you describe how you collaborated together to complete the assignment. This must include how much of the work can be attributed to each person by distributing 100 points (i.e. 100%) amongst the two people in the pair. Thus, if one student did much of the assignment you may decide to award her 65 points and the second student 35 points. In another pair where the work is more equally distributed, it might be 55 and 45. You must describe in the file why the points have been assigned as reported. Please provide useful justification, such as methods written by each, general contributions, how you collaborated together, etc.
Technical requirements
Be sure that all fields (instance variables) are declared with a private access specifier and the constructors and methods that are part of the public interface must be declared with a public access specifier.
Constants can be declared as public, there's no danger in doing this as the values cannot change.
Avoid declaring getters and setters (accessors and mutators) for every field. If you do that, you're tearing down the protection put in place via the private access specifier.
Implementation Guidelines and Hints
You muse use JavaDoc style comments for all classes and methods.
Avoid literal values. This is done by defining variables and assigning them a value and then using the variable. Recall the advantages associated with using variables rather than using literal values in your programs. You may need to define constants if the value in the variable is not to be changed.
Write code that is easy to read. Your code must be indented appropriately, use descriptive variable names, have comments throughout, use appropriate white spaces (i.e. spaces and blank lines), and related instructions should be organized well.
Always include comments to cite resources used. This includes those who may have helped you, such as tutors.
Documentation of your code. Provide comments throughout your code to explain key instructions or groups of instructions.
More may be added to clarify and as needed. Post questions and check Piazza discussions regularly.
Submission
By the deadline of 11:59pm on Thursday October 3, be sure you have committed and pushed all your work to GitHub.
