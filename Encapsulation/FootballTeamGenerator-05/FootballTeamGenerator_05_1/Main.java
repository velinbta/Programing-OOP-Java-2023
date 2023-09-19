package FootballTeamGenerator_05_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String EXIT_COMMAND = "END";
    public static final String TEAM_ADD_COMMAND = "Team";
    public static final String ADD_PLAYER_COMMAND = "Add";
    public static final String REMOVE_PLAYER_COMMAND = "Remove";
    public static final String RATING_TEAM_COMMAND = "Rating";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Team> teamsInfo = new LinkedHashMap<>();

        while (!input.equals(EXIT_COMMAND)) {

            String[] data = input.split(";", -1);
            String command = data[0];
            String teamName = data[1];

            if (teamInvalid(command, teamsInfo, teamName)) {
                // If command is not TEAM_ADD_COMMAND
                printTeamNotExist(teamName);
                input = scanner.nextLine();
                continue;
            }

            switch (command) {

                case TEAM_ADD_COMMAND:

                    addTeam(teamName, teamsInfo); // <- new Team

                    break;

                case ADD_PLAYER_COMMAND: {

                    String playerName = data[2];
                    int endurance = Integer.parseInt(data[3]);
                    int sprint = Integer.parseInt(data[4]);
                    int dribble = Integer.parseInt(data[5]);
                    int passing = Integer.parseInt(data[6]);
                    int shooting = Integer.parseInt(data[7]);

                    addPlayer(teamsInfo, teamName, playerName, endurance, sprint, dribble, passing, shooting);

                }
                break;

                case REMOVE_PLAYER_COMMAND:

                    String playerName = data[2];
                    removePlayer(teamsInfo, teamName, playerName); // <- if exists

                    break;

                case RATING_TEAM_COMMAND:

                    System.out.printf("%s - %.0f%n", teamName,
                            teamsInfo.get(teamName).getRating());

                    break;

            }

            input = scanner.nextLine();
        }

    }

    private static void addTeam(String teamName, Map<String, Team> teamInfo) {
        // Adds a new team if correct state
        try {
            Team team = new Team(teamName);
            teamInfo.putIfAbsent(teamName, team);
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private static void addPlayer(Map<String, Team> teamsInfo, String teamName, String playerName,
                                  int endurance, int sprint, int dribble, int passing, int shooting) {
        // Adds a new player to team if correct state of player
        try {

            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
            teamsInfo.get(teamName).addPlayer(player);

        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private static void removePlayer(Map<String, Team> teamsInfo, String teamName, String playerName) {
        // Removes player if player exists
        try {

            teamsInfo.get(teamName).removePlayer(playerName);

        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private static boolean teamInvalid(String command, Map<String, Team> teamsInfo, String teamName) {
        return !command.equals(TEAM_ADD_COMMAND) && !teamsInfo.containsKey(teamName);
    }

    private static void printTeamNotExist(String teamName) {
        System.out.printf("Team %s does not exist.\n", teamName);
    }

}
