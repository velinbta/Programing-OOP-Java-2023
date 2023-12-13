package bakery.repositories;

import bakery.entities.tables.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("FieldMayBeFinal")
public class TableRepositoryImpl implements TableRepository<Table> {

    private Collection<Table> tables;

    public TableRepositoryImpl() {
        this.tables = new ArrayList<>();
    }

    @Override
    public void add(Table table) {
        this.tables.add(table);
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(this.tables);
    }

    @Override
    public Table getByNumber(int number) {
        return this.tables.stream().filter(table -> table.getTableNumber() == number).
                findFirst().orElse(null);
    }

}
