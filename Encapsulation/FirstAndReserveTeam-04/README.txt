4. First and Reserve Team

/////////////////////////////////////////

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

Expand Person with proper validation for every field:
Names must be at least 3 symbols
Age must not be zero or negative
Salary can't be less than 460.0

/////////////////////////////////////////

Create a Team class. Add to this team all people you read.
All people younger than 40 go on the first team, others go on the reverse team.
At the end print first and reserve team sizes.

The class should have private fields for:
name: String
firstTeam: List<Person>
reserveTeam: List<Person>

The class should have constructor:
Team(String name)

Public methods for:
addPlayer(Person person): void
getFirstTeam(): List<Person> (Collections.unmodifiableList)
getReserveTeam(): List<Person> (Collections.unmodifiableList)

You should be able to use the class like this:

Team team = new Team("Black Eagles");

for (Person player: players) {
    team.addPlayer(player);
}

System.out.println("First team have " + team.getFirstTeam().size() + " players");
System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");


You should NOT be able to use the class like this:

Team team = new Team("Black Eagles");

for (Person player: players) {

if (player.getAge() < 40) {
   team.getFirstTeam().add(player);
} else {
   team.getReserveTeam().add(player);
}

}

Examples:

Input 1:
5
Asen Ivanov 20 2200
Boiko Borisov 57 3333
Ventsislav Ivanov 27 600
Grigor Dimitrov 25 666.66
Boiko Angelov 35 555

Output 1:
First team have 4 players
Reserve team have 1 players

Input 2:
4
Sara Cameron 21 1200
John Petrovich 53 850.50
Anna Glen 21 475
John Alekseevich 27 2100

Output 2:
First team have 3 players
Reserve team have 1 players