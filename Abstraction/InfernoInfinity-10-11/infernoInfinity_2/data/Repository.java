package infernoInfinity_2.data;

import infernoInfinity_2.weapons.Weapon;

public interface Repository {

    boolean addWeapon(String weaponName, Weapon weapon);

    Weapon getWeapon(String weaponName);

    boolean removeWeapon(String weaponName);

    String getStatistics();

}
