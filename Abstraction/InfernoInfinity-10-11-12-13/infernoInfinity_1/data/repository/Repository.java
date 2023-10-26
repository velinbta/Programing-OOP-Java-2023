package infernoInfinity_1.data.repository;

import infernoInfinity_1.weapons.Weapon;

public interface Repository {

    boolean addWeapon(String weaponName, Weapon weapon);

    Weapon getWeapon(String weaponName);

    boolean removeWeapon(String weaponName);

    String getStatistics();

}
