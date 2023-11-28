package restaurant.repository;

import restaurant.entity.table.Table;

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
    public void add(Table entity) {
        this.tables.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return this.tables.stream().filter(table -> table.getTableNumber() == number).
                findFirst().orElse(null);
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.tables);
    }

}
