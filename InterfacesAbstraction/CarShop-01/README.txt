1. Car Shop 
Build hierarchy from classes and interfaces for this UML diagram:

<<Car>>  <- <<Serializable>>

+TIRES: Integer
+getModel(): String
+getColor(): String
+getHorsePower(): Integer
+countryProduced(): String

Seat 
+toString(): String

Your hierarchy has to be used with this code.

public static void main(String[] args) {

    Car seat = new Seat("Leon", "gray", 110, "Spain");

    System.out.println(String.format(
            "%s is %s color and have %s horse power",
            seat.getModel(),
            seat.getColor(),
            seat.getHorsePower()));
    System.out.println(seat.toString());

} 

Examples:

Output:
Leon is gray color and have 110 horse power
This is Leon produced in Spain and have 4 tires