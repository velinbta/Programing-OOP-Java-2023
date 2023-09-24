2. Car Shop Extend

Build hierarchy from classes and interfaces for this UML diagram:

<<Car>>  <- <<Serializable>>
+ TIRES: Integer
+ getModel(): String
+ getColor(): String
+ getHorsePower(): Integer
+ getCountryProduced(): String

CarImpl <- Car
+ CarImpl(model, color, horsePower, countryProduced)
+ toString(): String

<<Rentable>>
+getMinRentDay(): Integer
+getPricePerDay(): Double

Audi
<- CarImpl
<- Rentable
- minRentDay: Integer
- pricePerDay: Double
+ toString(): String

<<Sellable>>
+ getPrice(): Double

Seat
<- CarImpl
<- Sellable
- price: Double
+ toString(): String

Sample code:

public static void main(String[] args) {

    Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
    Rentable audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

    printCarInfo(seat);
    printCarInfo(audi);

}

private static void printCarInfo(Car car) {

    System.out.println(String.format(
            "%s is %s color and have %s horse power",
            car.getModel(),
            car.getColor(),
            car.getHorsePower()));
    System.out.println(car.toString());

}

Output:
Leon is Gray color and have 110 horse power
This is Leon produced in Spain and have 4 tires
Leon sells for 11111.100000
A4 is Gray color and have 110 horse power
This is A4 produced in Germany and have 4 tires
Minimum rental period of 3 days. Price per day 99.900000