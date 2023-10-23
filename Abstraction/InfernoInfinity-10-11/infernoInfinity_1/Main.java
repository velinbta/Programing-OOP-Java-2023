package infernoInfinity_1;

import infernoInfinity_1.weapons.Axe;
import infernoInfinity_1.weapons.Knife;
import infernoInfinity_1.weapons.Sword;
import infernoInfinity_1.weapons.Weapon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String END_COMMAND = "END";
    public static final String CREATE_COMMAND = "Create";
    public static final String ADD_COMMAND = "Add";
    public static final String REMOVE_COMMAND = "Remove";
    public static final String PRINT_COMMAND = "Print";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Weapon> weaponsByName = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND)) {

            String[] data = input.split(";");
            String command = data[0];

            switch (command) {

                case CREATE_COMMAND: {

                    String weaponType = data[1];
                    String weaponName = data[2];

                    Weapon weapon = getWeapon(weaponType, weaponName);
                    weaponsByName.putIfAbsent(weaponName, weapon);

                }
                break;

                case ADD_COMMAND: {

                    String weaponName = data[1];

                    int socketIndex = Integer.parseInt(data[2]);
                    Gem gem = Gem.valueOf(data[3]);

                    Weapon weapon = weaponsByName.get(weaponName);
                    weapon.addGem(socketIndex, gem);

                }
                break;

                case REMOVE_COMMAND: {

                    String weaponName = data[1];
                    int socketIndex = Integer.parseInt(data[2]);

                    Weapon weapon = weaponsByName.get(weaponName);
                    weapon.removeGem(socketIndex);

                }
                break;

                case PRINT_COMMAND: {

                    String weaponName = data[1];
                    System.out.println(weaponsByName.get(weaponName));

                }
                break;

                default:
                    throw new IllegalArgumentException("Invalid command " + command);
            }

            input = scanner.nextLine();
        }

    }

    private static Weapon getWeapon(String weaponType, String weaponName) {
        // return Weapon based on type
        switch (weaponType) {
            case "AXE":
                return new Axe(weaponName);
            case "KNIFE":
                return new Knife(weaponName);
            case "SWORD":
                return new Sword(weaponName);
            default:
                throw new IllegalArgumentException("Unknown weapon type " + weaponType);
        }

    }

}
