2. Salary Increase

Create a class Person, which should have private fields for:
firstName: String
lastName: String
age: int
toString() - override

Read person with their names, age, and salary. Read percent bonus to every person salary.
People younger than 30 get a half bonus.
Add salary field and getter and setter with proper access.
New fields and methods:
salary: double 
increaseSalary(double bonus)

You should be able to use the class like this:

public static void main(String[] args) throws IOException { 

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(reader.readLine());
    List<Person> people = new ArrayList<>();

    for (int i = 0; i < n; i++) { 
        String[] input = reader.readLine().split(" ");
        people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
    }

    double bonus = Double.parseDouble(reader.readLine());

    for (Person person : people) {
        person.increaseSalary(bonus);
        System.out.println(person.toString());
    }

} 

Examples:

Input 1:
5
Angel Ivanov 65 2200
Boris Georgiev 57 3333
Veny Ivanov 27 600
Angel Harizanov 44 666.66
Boris Angelov 35 559.4
20

Output 1:
Angel Ivanov gets 2640.0 leva
Boris Georgiev gets 3999.6 leva
Veny Ivanov gets 660.0 leva
Angel Harizanov gets 799.992 leva
Boris Angelov gets 671.28 leva

Input 2:
4
Sara Cameron 21 1200
John Petrovich 53 850.50
Anna Glen 21 1640
John Alekseevich 43 2100
13

Output 2:
Sara Cameron gets 1278.0 leva
John Petrovich gets 961.065 leva
Anna Glen gets 1746.6 leva
John Alekseevich gets 2373.0 leva