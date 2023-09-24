package CarShop_01_1;

import java.io.Serializable;

public interface Car extends Serializable {

    Integer TIRES = 4;

    String getModel();

    String getColor();

    // Wrapper required
    Integer getHorsePower();

    // No "get" requirement
    String countryProduced();

}
