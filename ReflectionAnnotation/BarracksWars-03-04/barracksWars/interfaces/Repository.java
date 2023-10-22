package barracksWars.interfaces;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	boolean removeUnit(String unitType);

}
