package infernoInfinity_2.data;

import infernoInfinity_2.weapons.Weapon;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeaponRepository implements Repository {

    private final Map<String, Weapon> weaponsByName;

    public WeaponRepository() {
        this.weaponsByName = new LinkedHashMap<>();
    }

    @Override
    public boolean addWeapon(String weaponName, Weapon weapon) {

        if (weaponsByName.containsKey(weaponName))
            return false;

        this.weaponsByName.put(weaponName, weapon);
        return true;
    }

    @Override
    public Weapon getWeapon(String weaponName) {

        if (!this.containsWeapon(weaponName))
            throw new IllegalArgumentException("Weapon does not exist " + weaponName);

        return this.weaponsByName.get(weaponName);
    }

    @Override
    public boolean removeWeapon(String weaponName) {

        if (!this.containsWeapon(weaponName))
            return false;

        this.weaponsByName.remove(weaponName);
        return true;
    }

    @Override
    public String getStatistics() {

        StringBuilder stats = new StringBuilder();

        this.weaponsByName.values().forEach(weapon -> {
            stats.append(weapon.toString());
            stats.append(System.lineSeparator());
        });

        return stats.toString().trim();
    }

    private boolean containsWeapon(String weaponName) {
        return this.weaponsByName.containsKey(weaponName);
    }

}
