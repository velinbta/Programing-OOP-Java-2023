package infernoInfinity_2.core;

import infernoInfinity_2.Gem;
import infernoInfinity_2.data.Repository;
import infernoInfinity_2.weapons.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

    public static final String END_COMMAND = "END";
    public static final String CREATE_COMMAND = "Create";
    public static final String ADD_COMMAND = "Add";
    public static final String REMOVE_COMMAND = "Remove";
    public static final String PRINT_COMMAND = "Print";

    private final Repository repository;

    public Engine(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {

                String input = reader.readLine();

                if (END_COMMAND.equals(input)) {
                    break;
                }

                String[] data = input.split(";");

                this.interpretCommand(data);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private void interpretCommand(String[] data) {

        String command = data[0];

        switch (command) {

            case CREATE_COMMAND: {

                WeaponType weaponType = WeaponType.valueOf(data[1]);
                String weaponName = data[2];

                Weapon weapon = this.getWeapon(weaponType, weaponName);
                this.repository.addWeapon(weaponName, weapon);

            }
            break;

            case ADD_COMMAND: {

                String weaponName = data[1];

                int socketIndex = Integer.parseInt(data[2]);
                Gem gem = Gem.valueOf(data[3]);

                Weapon weapon = this.repository.getWeapon(weaponName);
                weapon.addGem(socketIndex, gem);

            }
            break;

            case REMOVE_COMMAND: {

                String weaponName = data[1];
                int socketIndex = Integer.parseInt(data[2]);

                Weapon weapon = this.repository.getWeapon(weaponName);
                weapon.removeGem(socketIndex);

            }
            break;

            case PRINT_COMMAND: {

                String weaponName = data[1];
                System.out.println(this.repository.getWeapon(weaponName));

            }
            break;

            default:
                throw new IllegalArgumentException("Invalid command " + command);

        }

    }

    private Weapon getWeapon(WeaponType type, String weaponName) {
        // return Weapon based on type
        switch (type) {
            case AXE:
                return new Axe(weaponName);
            case KNIFE:
                return new Knife(weaponName);
            case SWORD:
                return new Sword(weaponName);
            default:
                throw new IllegalArgumentException("Unknown weapon type " + type);
        }

    }

}
