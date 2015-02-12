Run MainClass.java inside main.java.com.ananthapillai.thoughtworks.assignment package.
By default the application will take sampleInput.txt inside /src/main/resources/file as input file.
Specify path as command line arguments to use a custom file as input.

Unit Tests can be run from test.java.com.ananthapillai.thoughtworks.assignment package.

Code Flow
1. Read line by line from input file.
2. Classify each line into 4 types (Assign primitive value, Assign derived value, Question-Primitive, Question-Derived) 
3. Process line based on the line type.
4. Output result associated with each line.

Assumptions:
1. The questions are followed after the conversion notes.(Questions dependent on notes following it will not be recognized)

==================================== INPUT =====================================
A sample input file will be like this:

glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?

==================================== OUTPUT ====================================
Corresponding output to this will be as given below :

pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about

================================================================================
Tools Used: Maven, JUnit
IDE used: NetBeans IDE 8.0