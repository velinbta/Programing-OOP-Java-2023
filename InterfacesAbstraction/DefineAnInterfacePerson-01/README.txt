1. Define an Interface Person
Define an interface Person with methods getName and getAge.
Define a class Citizen which implements Person and has a constructor which takes a String name and an int age.

<<Interface>> 
Person 
+ getName() : String
+ getAge() : int

Citizen
<- Person
- name: String
- age: int 
+ Citizen (String, int)
+ getName() : String
+ getAge() : int

Add the following code to your main method:

public static void main(String[] args) {

    Class[] citizenInterfaces = Citizen.class.getInterfaces();

    if(Arrays.asList(citizenInterfaces).contains(Person.class)) {

        Method[] fields = Person.class.getDeclaredMethods();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Person person = new Citizen(name,age); 
        System.out.println(fields.length);
        System.out.println(person.getName());
        System.out.println(person.getAge());

    }

} 

If you defined the interface and implemented it correctly, the test should pass.

Examples:

Input 1:
Peter
25

Output 1:
2
Peter
25

Input 2:
John
34

Output 2:
2
John
34