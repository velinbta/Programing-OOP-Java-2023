package infernoInfinity_2.weapons;

import infernoInfinity_2.Gem;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Weapon {

    private final String name;
    private final int numberOfSockets;
    private final Map<Integer, Gem> gemsByIndex;

    private int minDamage;
    private int maxDamage;

    private int strength;
    private int agility;
    private int vitality;

    protected Weapon(String name, int minDamage, int maxDamage, int numberOfSockets) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numberOfSockets = numberOfSockets;
        this.gemsByIndex = new LinkedHashMap<>();
    }

    public boolean addGem(int socketIndex, Gem gem) {
        if (!canAdd(socketIndex))
            return false;

        if (this.gemsByIndex.containsKey(socketIndex)) {
            this.removeStats(this.gemsByIndex.get(socketIndex));
        }

        this.gemsByIndex.put(socketIndex, gem);
        this.addStats(gem);

        return true;
    }

    public boolean removeGem(int socketIndex) {
        if (!this.gemsByIndex.containsKey(socketIndex))
            return false;

        this.removeStats(this.gemsByIndex.get(socketIndex));
        this.gemsByIndex.remove(socketIndex);

        return true;
    }

    private void addStats(Gem gem) {
        this.strength += gem.getStrength();
        this.agility += gem.getAgility();
        this.vitality += gem.getVitality();

        this.minDamage += (gem.getStrength() * 2) + gem.getAgility();
        this.maxDamage += (gem.getStrength() * 3) + (gem.getAgility() * 4);
    }

    private void removeStats(Gem gem) {
        this.strength -= gem.getStrength();
        this.agility -= gem.getAgility();
        this.vitality -= gem.getVitality();

        this.minDamage -= (gem.getStrength() * 2) + gem.getAgility();
        this.maxDamage -= (gem.getStrength() * 3) + (gem.getAgility() * 4);
    }

    private boolean canAdd(int socketIndex) {
        return socketIndex >= 0 && socketIndex < this.numberOfSockets;
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.minDamage, this.maxDamage, this.strength, this.agility, this.vitality);
    }

}
