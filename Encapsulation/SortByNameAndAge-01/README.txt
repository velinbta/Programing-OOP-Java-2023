1. Sort by Name and Age
Create a class Person, which should have private fields for:
firstName: String
lastName: String
age: int

toString() - override
You should be able to use the class like this:

public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());

    List<Person> people = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        String[] input = reader.readLine().split(" ");
        people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
    }

    Collections.sort(people, (firstPerson, secondPerson) -> {
        int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

        if (sComp != 0) {
            return sComp;
        } else { 
            return Integer.compare(firstPerson.getAge(), secondPerson.getAge()); 
        }
    });

    for (Person person : people) {
        System.out.println(person.toString());
    }

} 

Examples:

Input 1:
5
Angel Ivanov 65
Boris Georgiev 57
Veny Ivanov 27
Angel Harizanov 44
Boris Angelov 35

Output 1:
Angel Harizanov is 44 years old.
Angel Ivanov is 65 years old.
Boris Angelov is 35 years old.
Boris Georgiev is 57 years old.
Veny Ivanov is 27 years old.

Input 2:
4
Sara Cameron 21
John Petrovich 53
Anna Glen 21
John Alekseevich 43

Output 2:
Anna Glen is 21 years old.
John Alekseevich is 43 years old.
John Petrovich is 53 years old.
Sara Cameron is 21 years old.