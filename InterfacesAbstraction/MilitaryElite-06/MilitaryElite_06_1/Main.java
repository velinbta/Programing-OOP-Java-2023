package MilitaryElite_06_1;

import java.util.*;

public class Main {

    public static final String END_COMMAND = "End";
    public static final String PRIVATE_COMMAND = "Private";
    public static final String LIEUTENANT_GENERAL_COMMAND = "LieutenantGeneral";
    public static final String ENGINEER_COMMAND = "Engineer";
    public static final String COMMANDO_COMMAND = "Commando";
    public static final String SPY_COMMAND = "Spy";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Collection<Soldier> soldiers = new ArrayList<>();

        while (!input.equals(END_COMMAND)) {

            String[] data = input.split("\\s+");

            // in case of invalid Corps
            Optional<Soldier> soldier = getSoldier(data, soldiers);
            soldier.ifPresent(soldiers::add);

            input = scanner.nextLine();

        }

        soldiers.forEach(System.out::println);

    }

    private static Optional<Soldier> getSoldier(String[] data, Collection<Soldier> soldiers) {
        // returns Optional of Soldier based on command - data[0]
        int dataSize = data.length;
        String command = data[0];
        int id = Integer.parseInt(data[1]);
        String firstName = data[2];
        String lastName = data[3];

        if (command.equals(SPY_COMMAND)) { // <- Single case of no salary
            String codeNumber = data[4];
            return Optional.of(new Spy(id, firstName, lastName, codeNumber));
        }

        double salary = Double.parseDouble(data[4]);

        switch (command) {

            case PRIVATE_COMMAND:

                return Optional.of(new Private(id, firstName, lastName, salary));

            case LIEUTENANT_GENERAL_COMMAND:

                LieutenantGeneral lg = new LieutenantGeneral(id, firstName, lastName, salary);

                if (LieutenantGeneral.DEFAULT_SIZE == dataSize) {
                    return Optional.of(lg);
                }

                // add always! already existing Privates to lg
                for (int i = LieutenantGeneral.DEFAULT_SIZE; i < dataSize; i++) {
                    int existingPrivateId = Integer.parseInt(data[i]);

                    soldiers.stream().filter(p -> p.getId() == existingPrivateId).findFirst()
                            .ifPresent(soldier -> lg.addPrivate((Private) soldier));
                }

                return Optional.of(lg);

            case ENGINEER_COMMAND:

                try { // <- parseCorps or skip
                    Engineer.Corps corps = Engineer.Corps.parseCorps(data[5]);
                    Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);

                    for (int i = Engineer.DEFAULT_SIZE; i < dataSize; i += 2) {
                        // add always! valid repairs
                        String repairName = data[i];
                        int hoursTaken = Integer.parseInt(data[i + 1]);
                        Repair repair = new Repair(repairName, hoursTaken);
                        engineer.addRepair(repair);

                    }

                    return Optional.of(engineer);

                } catch (IllegalArgumentException exception) {
                    return Optional.empty();
                }

            case COMMANDO_COMMAND:

                try {
                    // if invalid Corps - Optional.empty();
                    Commando.Corps corps = Commando.Corps.parseCorps(data[5]);
                    Commando commando = new Commando(id, firstName, lastName, salary, corps);

                    for (int i = Commando.DEFAULT_SIZE; i < dataSize; i += 2) {

                        try {
                            String codeName = data[i];
                            Mission.State state = Mission.State.parseState(data[i + 1]);

                            Mission mission = new Mission(codeName, state);
                            commando.addMission(mission);

                        } catch (IllegalArgumentException ignored) {
                            // skipping only the mission if mission state illegal
                        }

                    }

                    return Optional.of(commando);

                } catch (IllegalArgumentException exception) {
                    return Optional.empty();
                }

        }

        return Optional.empty();
    }

}