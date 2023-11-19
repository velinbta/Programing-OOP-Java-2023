package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Map<String, Area> areaByName;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areaByName = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {

        Area newArea = this.getArea(areaType, areaName);
        this.areaByName.putIfAbsent(areaName, newArea);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {

        Food newFood = this.getFood(foodType);
        this.foodRepository.add(newFood);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {

        Food foodByType = this.foodRepository.findByType(foodType);

        if (Objects.isNull(foodByType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        Area area = this.areaByName.get(areaName);
        area.addFood(foodByType);

        this.foodRepository.remove(foodByType);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {

        Animal newAnimal = this.getAnimal(animalType, animalName, kind, price);

        Area area = this.areaByName.get(areaName);

        if (!this.canLiveInArea(area, animalType)) {
            return ConstantMessages.AREA_NOT_SUITABLE;
        }

        area.addAnimal(newAnimal);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {

        Area area = this.areaByName.get(areaName);
        area.feed();

        return String.format(ConstantMessages.ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {

        Area area = this.areaByName.get(areaName);
        double allAnimalsKg = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, allAnimalsKg);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        this.areaByName.values().forEach(area -> {
            statistics.append(area.getInfo());
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private boolean canLiveInArea(Area area, String animalType) {

        String areaType = area.getClass().getSimpleName();

        return areaType.equals("WaterArea") && animalType.equals("AquaticAnimal") ||
                areaType.equals("LandArea") && animalType.equals("TerrestrialAnimal");
    }

    private Area getArea(String areaType, String areaName) {

        switch (areaType) {

            case "WaterArea":
                return new WaterArea(areaName);
            case "LandArea":
                return new LandArea(areaName);
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

    }

    private Food getFood(String foodType) {

        switch (foodType) {

            case "Vegetable":
                return new Vegetable();
            case "Meat":
                return new Meat();
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }

    }

    private Animal getAnimal(String animalType, String animalName, String kind, double price) {

        switch (animalType) {

            case "AquaticAnimal":
                return new AquaticAnimal(animalName, kind, price);
            case "TerrestrialAnimal":
                return new TerrestrialAnimal(animalName, kind, price);
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

    }

}
