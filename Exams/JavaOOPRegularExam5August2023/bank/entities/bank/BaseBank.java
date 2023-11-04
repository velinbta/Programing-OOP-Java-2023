package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public abstract class BaseBank implements Bank {

    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    protected BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public int sumOfInterestRates() {
        return this.loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addClient(Client client) {
        if (this.capacity <= 0) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }

        this.clients.add(client);
        this.capacity--;
    }

    @Override // always valid clients, nevertheless -> if
    public void removeClient(Client client) {
        if (this.clients.remove(client)) {
            this.capacity++;
        }
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public Collection<Client> getClients() {
        return Collections.unmodifiableCollection(this.clients);
    }

    @Override
    public Collection<Loan> getLoans() {
        return Collections.unmodifiableCollection(this.loans);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getStatistics() {

        StringBuilder bankOutput = new StringBuilder();

        bankOutput.append(String.format("Name: %s, Type: %s", this.getName(), this.getClass().getSimpleName()));
        bankOutput.append(System.lineSeparator());

        String clientName = this.clients.isEmpty()
                ? "Clients: none"
                : "Clients: ";

        bankOutput.append(clientName);

        bankOutput.append(this.clients.stream().map(Client::getName).collect(Collectors.joining(", ")));
        bankOutput.append(System.lineSeparator());

        bankOutput.append(String.format("Loans: %d, Sum of interest rates: %d",
                this.loans.size(), this.sumOfInterestRates()));

        return bankOutput.toString().trim();
    }

}
