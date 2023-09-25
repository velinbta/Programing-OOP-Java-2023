3. Say Hello 
Build hierarchy from classes and interfaces for this UML diagram:

<<Person>>
+ getName(): String
+ sayHello(): String

Bulgarian
<- Person
- name: String
+ sayHello(): String

European
<- Person
- name: String

Chinese
<- Person
- name: String
+ sayHello(): String

Sample code given:

public static void main(String[] args) {

    List<Person> persons = new ArrayList<>();
    
    persons.add(new Bulgarian("Peter"));
    persons.add(new European("Peter"));
    persons.add(new Chinese("Peter"));

    for (Person person : persons) {
        print(person);
    }

}

private static void print(Person person) {
    System.out.println(person.sayHello());
}
