package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public abstract class BaseWorker implements Worker {

    private String name;
    private int strength;
    private Collection<Tool> tools;

    protected BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void working() {

        int workStrength = this.getStrength() - 10;

        try {
            this.setStrength(workStrength);
        } catch (IllegalArgumentException e) {
            this.setStrength(0);
        }

    }

    @Override
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.getStrength() > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return Collections.unmodifiableCollection(this.tools);
    }

}
