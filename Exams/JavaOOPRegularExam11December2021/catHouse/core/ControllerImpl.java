package catHouse.core;

import catHouse.common.ConstantMessage;
import catHouse.common.ExceptionMessage;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository toyRepository;
    private Map<String, House> housesByName;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.housesByName = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {

        House newHouse = this.getHouseByType(type, name);
        this.housesByName.put(name, newHouse);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_HOUSE_TYPE_FORMAT, type);
    }

    @Override
    public String buyToy(String type) {

        Toy newToy = this.getToyByType(type);
        this.toyRepository.buyToy(newToy);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_TOY_TYPE_FORMAT, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {

        Toy toyByType = this.toyRepository.findFirst(toyType);

        if (Objects.isNull(toyByType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.NO_TOY_FOUND_FORMAT, toyType));
        }

        this.housesByName.get(houseName).buyToy(toyByType);
        this.toyRepository.removeToy(toyByType);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_TOY_IN_HOUSE_FORMAT, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat newCat = this.getCatByType(catType, catName, catBreed, price);

        House houseByName = this.housesByName.get(houseName);

        if (!this.catCanLiveInHouse(houseByName, catType)) {
            return ConstantMessage.UNSUITABLE_HOUSE;
        }

        houseByName.addCat(newCat);

        return String.format(ConstantMessage.SUCCESSFULLY_ADDED_CAT_IN_HOUSE_FORMAT, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {

        House houseByName = this.housesByName.get(houseName);
        houseByName.feeding();

        return String.format(ConstantMessage.FEEDING_CAT_FORMAT, houseByName.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {

        House houseByName = this.housesByName.get(houseName);

        double sumCatPrices = houseByName.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumToyPrices = houseByName.getToys().stream().mapToDouble(Toy::getPrice).sum();

        double total = sumCatPrices + sumToyPrices;

        return String.format(ConstantMessage.VALUE_HOUSE_FORMAT, houseName, total);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        this.housesByName.values().forEach(house -> {
            statistics.append(house.getStatistics());
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private boolean catCanLiveInHouse(House houseByName, String catType) {

        String houseType = houseByName.getClass().getSimpleName();

        return catType.equals("ShorthairCat") && houseType.equals("ShortHouse") ||
                catType.equals("LonghairCat") && houseType.equals("LongHouse");
    }

    private House getHouseByType(String type, String name) {

        switch (type) {

            case "ShortHouse":
                return new ShortHouse(name);
            case "LongHouse":
                return new LongHouse(name);
            default:
                throw new NullPointerException(ExceptionMessage.INVALID_HOUSE_TYPE);
        }

    }

    private Toy getToyByType(String type) {

        switch (type) {

            case "Ball":
                return new Ball();
            case "Mouse":
                return new Mouse();
            default:
                throw new IllegalArgumentException(ExceptionMessage.INVALID_TOY_TYPE);
        }

    }

    private Cat getCatByType(String catType, String catName, String catBreed, double price) {

        switch (catType) {

            case "ShorthairCat":
                return new ShorthairCat(catName, catBreed, price);
            case "LonghairCat":
                return new LonghairCat(catName, catBreed, price);
            default:
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAT_TYPE);
        }

    }

}
