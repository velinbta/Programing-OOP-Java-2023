6. *Military Elite 
Create the following class hierarchy:

SoldierImpl - general class for soldiers, holding id (int), first name, and last name
	PrivateImpl - the lowest base soldier type, holding the field salary (double)
		LieutenantGeneralImpl - holds a set of PrivatesImpl under his command
			public void addPrivate(Private priv)
	SpecialisedSoldierImpl - general class for all specialized soldiers - holds the corps of the soldier.
The corps can only be one of the following: "Airforces" or "Marines" (Enumeration)
		- EngineerImpl - holds a set of repairs. A repair holds a part name and hours worked (int)
			public void addRepair(Repair repair)
			public Collection<Repair> getRepairs()
		- CommandoImpl - holds a set of missions.
A mission holds a code name and a state (Enumeration: "inProgress" or "finished"). A mission can be finished through the method completeMission()
			public void addMission(Mission mission)
			public Collection<Mission> getMissions()
SpyImpl - holds the code number of the spy.

Extract interfaces for each class (e.g. Soldier, Private, LieutenantGeneral, etc.).
The interfaces should hold their public get methods (e.g. Soldier should hold getId, getFirstName, and getLastName).
Each class should implement its respective interface.

Validate the input where necessary (corps, mission state):
Input should match exactly one of the required values, otherwise, it should be treated as invalid.
In the case of invalid corps, the entire line should be skipped.
In the case of an invalid mission state, only the mission should be skipped. 

You will receive from the console an unknown amount of lines containing information about soldiers until the command "End" is received.
The information will be in one of the following formats: 
Private: "Private {id} {firstName} {lastName} {salary}"
LieutenantGeneral: "LieutenantGeneral {id} {firstName} {lastName} {salary} {private1Id} {private2Id} ... {privateNId}" where privateXId will always be an Id of a private already received through the input.
Engineer: "Engineer {id} {firstName} {lastName} {salary} {corps} {repair1Part} {repair1Hours} ... {repairNPart} {repairNHours}" where repairXPart is the name of a repaired part and repairXHours the hours it took to repair it (the two parameters will always come paired).
Commando: "Commando {id} {firstName} {lastName} {salary} {corps} {mission1CodeName}  {mission1state} ... {missionNCodeName} {missionNstate}" a missions code name, description and state will always come together.
Spy: "Spy {id} {firstName} {lastName} {codeNumber}" 

Define proper constructors. Avoid code duplication through abstraction.
Override toString() in all classes to print detailed information about the object.

Privates:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}"

Spy:
"Name: {firstName} {lastName} Id: {id}
Code Number: {codeNumber}"

LieutenantGeneral:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}
Privates:
{private1 ToString()}
{private2 ToString()}
...
{privateN ToString()}" 
Note: privates must be sorted by id in descending order.

Engineer:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}
Corps: {corps}
Repairs:
{repair1 ToString()}
{repair2 ToString()}
...
{repairN ToString()}"

Commando:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}
Corps: {corps}
Missions:
{mission1 ToString()}
{mission2 ToString()}
...
{missionN ToString()}"

Repair:
"Part Name: {partName} Hours Worked: {hoursWorked}" 
Mission:

"Code Name: {codeName} State: {state}" 
NOTE: Salary should be printed and rounded to two decimal places after the separator. 

Examples:

Input 1:
Private 1 Peter Petrov 22.22
Commando 13 Stam Stamov 13.1 Airforces
Private 222 Tom Tomson 80.08
LieutenantGeneral 3 John Johnson 100 222 1
End

Output 1:
Name: Peter Petrov Id: 1 Salary: 22.22
Name: Stam Stamov Id: 13 Salary: 13.10
Corps: Airforces
Missions:
Name: Tom Tomson Id: 222 Salary: 80.08
Name: John Johnson Id: 3 Salary: 100.00
Privates:
Name: Tom Tomson Id: 222 Salary: 80.08
Name: Peter Petrov Id: 1 Salary: 22.22

Input 2:
Engineer 7 Peter Petrov 12.23 Marines Boat 2 Crane 17 
Commando 19 Sara Johnson 150.15 Airforces HairyFoot finished Freedom inProgress 
End

Output 2:
Name: Peter Petrov Id: 7 Salary: 12.23
Corps: Marines
Repairs:
Part Name: Boat Hours Worked: 2
Part Name: Crane Hours Worked: 17
Name: Sara Johnson Id: 19 Salary: 150.15
Corps: Airforces
Missions:
Code Name: HairyFoot State: finished
Code Name: Freedom State: inProgress

Input 3:
LieutenantGeneral 17 No Units 500.01
Spy 7 James Bond 007
Spy 8 James Boned 008
End

Output 3:
Name: No Units Id: 17 Salary: 500.01
Privates:
Name: James Bond Id: 7
Code Number: 007
Name: James Boned Id: 8
Code Number: 008