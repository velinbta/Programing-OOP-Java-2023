4. Say Hello Extend 
Build hierarchy from classes and interfaces for this UML diagram

<<Person>> 
+ getName(): String
+ sayHello(): String 

(Abstract) BasePerson
<- Person 
- name: String
# BasePerson(name)
+ getName(): String
- setName(): void 

Bulgarian
<- BasePerson
+ Bulgarian(name)
+ sayHello(): String

European
<- BasePerson
+ European(name)
+ sayHello(): String 

Chinese
<- BasePerson
+ Chinese(name)
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
