package infernoInfinity_1;

import infernoInfinity_1.data.Information;
import infernoInfinity_1.data.repository.Repository;
import infernoInfinity_1.data.repository.WeaponRepository;
import infernoInfinity_1.weapons.Axe;
import infernoInfinity_1.weapons.Knife;
import infernoInfinity_1.weapons.Sword;
import infernoInfinity_1.weapons.Weapon;

import java.util.Scanner;

import static infernoInfinity_1.data.commands.CommandNames.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Repository repository = new WeaponRepository();

        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND)) {

            String[] data = input.split(";");
            String command = data[0];

            switch (command) {

                case CREATE_COMMAND: {

                    String weaponType = data[1];
                    String weaponName = data[2];

                    Weapon weapon = getWeapon(weaponType, weaponName);
                    repository.addWeapon(weaponName, weapon);

                }
                break;

                case ADD_COMMAND: {

                    String weaponName = data[1];

                    int socketIndex = Integer.parseInt(data[2]);
                    Gem gem = Gem.valueOf(data[3]);

                    Weapon weapon = repository.getWeapon(weaponName);
                    weapon.addGem(socketIndex, gem);

                }
                break;

                case REMOVE_COMMAND: {

                    String weaponName = data[1];
                    int socketIndex = Integer.parseInt(data[2]);

                    Weapon weapon = repository.getWeapon(weaponName);
                    weapon.removeGem(socketIndex);

                }
                break;

                case PRINT_COMMAND: {

                    String weaponName = data[1];
                    System.out.println(repository.getWeapon(weaponName));

                }
                break;

                case COMPARE_COMMAND:

                    String firstWeaponName = data[1];
                    String secondWeaponName = data[2];

                    Weapon firstWeapon = repository.getWeapon(firstWeaponName);
                    Weapon secondWeapon = repository.getWeapon(secondWeaponName);

                    String greaterWeapon = firstWeapon.compareTo(secondWeapon) < 0
                            ? secondWeapon.getToStringPlusItemLevel()
                            : firstWeapon.getToStringPlusItemLevel();

                    System.out.println(greaterWeapon);

                    break;

                case AUTHOR_COMMAND:

                case REVISION_COMMAND:

                case REVIEWERS_COMMAND:

                case DESCRIPTION_COMMAND:

                    System.out.println(getAnnotationInfoAsString(command));
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

    private static String getAnnotationInfoAsString(String methodName) {
        // return annotation default method as String
        Information info = Weapon.class.getDeclaredAnnotation(Information.class);

        switch (methodName) {
            case AUTHOR_COMMAND:
                return "Author: " + info.author();
            case REVISION_COMMAND:
                return "Revision: " + info.revision();
            case DESCRIPTION_COMMAND:
                return "Class description: " + info.description();
            case REVIEWERS_COMMAND:
                return "Reviewers: " + info.reviewers();
            default:
                throw new IllegalArgumentException("Unknown annotation method " + methodName);
        }

    }

}
