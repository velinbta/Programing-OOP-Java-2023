3. Players and Monsters
Create a package hero.
Your task is to create the following game hierarchy:

Hero
Elf <- Hero
MuseElf <- Elf

Hero
Wizard <- Hero
DarkWizard <- Wizard
SoulMaster <- DarkWizard

Hero
Knight <- Hero
DarkKnight <- Knight
BladeKnight <- DarkKnight


Create a class Hero. It should contain the following members:
A public constructor, which accepts:
username - String
level - int

The following fields:
username - String
level - int

Getters for username and level
toString() method

Sample toString()
@Override
public String toString() {
    return String.format("Type: %s Username: %s Level: %s",
            this.getClass().getName(),
            this.getUsername(),
            this.getLevel());
}