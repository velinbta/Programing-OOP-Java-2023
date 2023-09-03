3. Student System 
You are given a working project for a small Student System, but the code is very poorly organized.
Break up the code logically into smaller functional units - methods and classes and don't break the functionality.

The program supports the following commands:
"Create {studentName} {studentAge} {studentGrade}" - creates a new student and adds them to the repository.
"Show {studentName}" - prints on the console information about a student in the format:
"{studentName} is {studentAge} years old. {commentary}.", where the commentary is
based on the student's grade.
"Exit" - closes the program.
Do not add any extra validation or functionality to the app!

Examples:

Input 1:
Create Peter 20 5.50
Create Maria 18 4.50
Create George 25 3
Show Peter
Show Maria
Exit

Output 1:
Peter is 20 years old. Excellent student.
Maria is 18 years old. Average student.

Input 2:
Create Teo 19 2.00
Show Sam
Show Teo
Create Sam 20 3.00
Show Teo
Show Sam
Exit

Output 2:
Teo is 19 years old. Very nice person.
Teo is 19 years old. Very nice person.
Sam is 20 years old. Very nice person.