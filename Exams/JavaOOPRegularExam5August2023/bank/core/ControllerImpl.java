package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;
import bank.repositories.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository loans;
    private Map<String, Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new LinkedHashMap<>();
    }

    @Override
    public String addBank(String type, String name) {

        Bank newBank = getBankByTypeOrNull(type, name);

        if (newBank == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);
        }

        this.banks.putIfAbsent(name, newBank);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {

        Loan newLoan = getLoanByTypeOrNull(type);

        if (newLoan == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }

        this.loans.addLoan(newLoan);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {

        Bank bank = this.banks.get(bankName);

        Loan foundLoan = this.loans.findFirst(loanType);

        if (foundLoan == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }

        bank.addLoan(foundLoan);
        this.loans.removeLoan(foundLoan);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }


    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {

        Client newClient = getClientByTypeOrNull(clientType, clientName, clientID, income);

        if (newClient == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
        }

        Bank bank = this.banks.get(bankName);

        boolean isSuitable = checkSuitable(bank, clientType);

        if (!isSuitable) {
            return ConstantMessages.UNSUITABLE_BANK;
        }

        bank.addClient(newClient);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {

        Bank bank = this.banks.get(bankName);

        double clientsIncome = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double loansAmount = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();

        double totalSum = clientsIncome + loansAmount;

        return String.format(ConstantMessages.FUNDS_BANK, bankName, totalSum);
    }

    private boolean checkSuitable(Bank bank, String clientType) {

        String bankType = bank.getClass().getSimpleName();

        return clientType.equals("Student") && bankType.equals("BranchBank") ||
                clientType.equals("Adult") && bankType.equals("CentralBank");
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        this.banks.values().forEach(bank -> {
            statistics.append(bank.getStatistics());
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private Loan getLoanByTypeOrNull(String type) {

        switch (type) {

            case "StudentLoan":
                return new StudentLoan();
            case "MortgageLoan":
                return new MortgageLoan();
            default:
                return null;
        }

    }

    private Client getClientByTypeOrNull(String clientType, String clientName, String clientID, double income) {

        switch (clientType) {

            case "Adult":
                return new Adult(clientName, clientID, income);
            case "Student":
                return new Student(clientName, clientID, income);
            default:
                return null;

        }

    }

    private Bank getBankByTypeOrNull(String type, String name) {

        switch (type) {

            case "CentralBank":
                return new CentralBank(name);
            case "BranchBank":
                return new BranchBank(name);
            default:
                return null;

        }

    }

}
