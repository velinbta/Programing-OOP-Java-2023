10. *Inferno Infinity 
If you've been involved with the creation of Inferno III last year, you may be informed of the disastrous critic reception it has received.
Nevertheless, your company is determined to satisfy its fan base, so a sequel is coming.
You will develop the crafting module of the game using the latest OOP trends.

You have three different weapons (Axe, Sword and Knife) which have base stats and a name.
The base stats are min damage, max damage and number of sockets (sockets are basically holes, in which you can insert gems).
Below are the base stats for the three weapon types: 
Axe (5-10 damage, 4 sockets)
Sword (4-6 damage, 3 sockets)
Knife (3-4 damage, 2 sockets)

Additionally, every weapon provides a bonus to three magical stats - strength, agility and vitality.
At first the bonus of every magical stat is zero and can be increased with gems which are inserted into the weapon. 
Every gem provides a bonus to all three of the magical stats.

There are three different kind of gems: 
Ruby (+7 strength, +2 agility, +5 vitality) 
Emerald (+1strength, +4 agility, +9 vitality)
Amethyst (+2 strength, +8 agility, +4 vitality)

Every point of strength adds +2 to min damage and +3 to max damage.
Every point of agility adds +1 to min damage and +4 to max damage. Vitality does not add damage.
Your job is to implement the functionality to read some weapons from the console.
And optionally to insert or remove gems at different socket indexes until you receive the END command.

Examples:

Input 1:
Create;AXE;Axe of Misfortune
Add;Axe of Misfortune;0;RUBY
Print;Axe of Misfortune
END

Output 1:
Axe of Misfortune: 21-39 Damage, +7 Strength, +2 Agility, +5 Vitality 

Input 2:
Create;AXE;Axe of Misfortune
Add;Axe of Misfortune;0;RUBY
Remove;Axe of Misfortune;0
Print;Axe of Misfortune
END

Output 2:
Axe of Misfortune: 5-10 Damage, +0 Strength, +0 Agility, +0 Vitality


11. *Inferno Infinity - @Override the toString() Method 
If you haven't already, override the toString() method of the Weapon class you have created for the Inferno Infinity  problem.
Try using the @Override annotation.
Note 
Pay attention to the actual overriding of the method.


12. *Inferno Infinity - @Override the compareTo() Method 
Extend your solution a bit further by making your Weapon class to be comparable to other weapons.
Every weapon should have an item level which is calculated by the average of the min and max damage, plus every additional stat it has.
Consider the Axe of Misfortune imbued with a Ruby from the zero tests:
Axe of Misfortune Item Level: ((21 + 39) / 2) + 7 + 2 + 5 = 44.0

Implement additional Print (prints the greater weapon with its item level).
Implement Compare command, which compares two weapons by their non-rounded item level and prints the greater of two weapons' name and its item level.
Display one numbers after the decimal separator (e.g. 54.40123 == 54.4):

Compare;{weapon name};{weapon name}
Print the greater of the two weapons in the following format:
"{weapon's name}: {min damage}-{max damage} Damage, +{points} Strength, +{points} Agility, +{points} Vitality (Item Level: {items level})" 
If both weapons have equal item level, print the first one. 
Note 
Pay attention to the actual overriding of the method.

Example:

Input:
Create;AXE;Axe of Misfortune
Add;Axe of Misfortune;0;RUBY
Create;KNIFE;Thieves Blade
Add;Thieves Blade;0;AMETHYST
Add;Thieves Blade;1;AMETHYST
Compare;Axe of Misfortune;Thieves Blade
END

Output:
Thieves Blade: 27-80 Damage, +4 Strength, +16 Agility, +8 Vitality (Item Level: 81.5)