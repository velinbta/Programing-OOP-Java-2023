package bank.core;

import bank.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class EngineImpl implements Engine {

    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        while (true) {

            String result;

            try {

                result = processInput();

                if (result.equals(Command.END.name())) {
                    break;
                }

            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }

    }

    private String processInput() throws IOException {

        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.parseCommand(tokens[0]);

        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case ADD_BANK:
                result = addBank(data);
                break;
            case ADD_LOAN:
                result = addLoan(data);
                break;
            case RETURNED_LOAN:
                result = returnedLoan(data);
                break;
            case ADD_CLIENT:
                result = addClient(data);
                break;
            case FINAL_CALCULATION:
                result = finalCalculation(data);
                break;
            case STATISTICS:
                result = getStatistics();
                break;
            case END:
                result = Command.END.name();
                break;
        }

        return result;

    }

    private String addBank(String[] data) {
        String bankType = data[0];
        String bankName = data[1];
        return this.controller.addBank(bankType, bankName);
    }

    private String addLoan(String[] data) {
        String loanType = data[0];
        return this.controller.addLoan(loanType);
    }

    private String returnedLoan(String[] data) {
        String bankName = data[0];
        String loanType = data[1];
        return this.controller.returnedLoan(bankName, loanType);
    }

    private String addClient(String[] data) {
        String bankName = data[0];
        String clientType = data[1];
        String clientName = data[2];
        String clientID = data[3];
        double income = Double.parseDouble(data[4]);
        return this.controller.addClient(bankName, clientType, clientName, clientID, income);
    }

    private String finalCalculation(String[] data) {
        String bankName = data[0];
        return this.controller.finalCalculation(bankName);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }

}

