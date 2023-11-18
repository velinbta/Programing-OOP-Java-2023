package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.BaseBooth;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<BaseBooth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
                          CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<BaseBooth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {

        // if that is the second action - will be considered a "mistake", in OJS logic
        if (Objects.nonNull(this.delicacyRepository.getByName(name))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        Delicacy newDelicacy = this.getDelicacy(type, name, price);

        this.delicacyRepository.add(newDelicacy);

        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

        // if that is the second action - will be considered a "mistake", in OJS logic
        if (Objects.nonNull(this.cocktailRepository.getByName(name))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        Cocktail newCocktail = this.getCocktail(type, name, size, brand);

        this.cocktailRepository.add(newCocktail);

        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {

        // if that is the second action - will be considered a "mistake", in OJS logic
        if (Objects.nonNull(this.boothRepository.getByNumber(boothNumber))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
        }

        BaseBooth newBooth = this.getBooth(type, boothNumber, capacity);

        this.boothRepository.add(newBooth);

        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {

        Booth firstAvailableBooth = this.boothRepository.getAll().stream().
                filter(booth -> !booth.isReserved() && numberOfPeople <= booth.getCapacity()).
                findFirst().orElse(null);

        if (Objects.isNull(firstAvailableBooth)) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        firstAvailableBooth.reserve(numberOfPeople);

        return String.format(OutputMessages.BOOTH_RESERVED, firstAvailableBooth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {

        Booth boothByName = this.boothRepository.getByNumber(boothNumber);

        double boothBill = boothByName.getBill();
        double boothPriceForPeople = boothByName.getPrice();

        double boothIncome = boothBill + boothPriceForPeople;

        this.totalIncome += boothIncome;

        boothByName.clear();

        return String.format(OutputMessages.BILL, boothNumber, boothIncome);
    }

    @Override
    public String orderDelicacy(int boothNumber, String delicacyName) {

        BaseBooth booth = boothRepository.getByNumber(boothNumber);
        Delicacy food = delicacyRepository.getByName(delicacyName);

        if (Objects.isNull(booth) || !booth.isReserved()) {
            return String.format(OutputMessages.WRONG_BOOTH_NUMBER, boothNumber);
        }

        if (Objects.isNull(food)) {
            return String.format(OutputMessages.NONE_EXISTENT_DELICACY, delicacyName);
        }

        booth.orderDelicacy(food);

        return String.format(OutputMessages.BOOTH_ORDER_SUCCESSFUL, boothNumber, delicacyName);
    }

    @Override
    public String orderCocktail(int boothNumber, String cocktailName, String cocktailBrand) {

        BaseBooth booth = boothRepository.getByNumber(boothNumber);
        Cocktail cocktail = cocktailRepository.getByName(cocktailName);

        if (Objects.isNull(booth) || !booth.isReserved()) {
            return String.format(OutputMessages.WRONG_BOOTH_NUMBER, boothNumber);
        }

        if (Objects.isNull(cocktail)) {
            return String.format(OutputMessages.NON_EXISTENT_COCKTAIL, cocktailName, cocktailBrand);
        }

        booth.orderCocktail(cocktail);

        return String.format(OutputMessages.COCKTAIL_ORDER_SUCCESSFUL, boothNumber, cocktailName, cocktailBrand);

    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, this.totalIncome);
    }

    private BaseBooth getBooth(String type, int boothNumber, int capacity) {

        switch (BoothType.parseBooth(type)) {

            case OPEN_BOOTH:
                return new OpenBooth(boothNumber, capacity);
            case PRIVATE_BOOTH:
                return new PrivateBooth(boothNumber, capacity);
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_BOOTH_TYPE, type));
        }

    }

    private Cocktail getCocktail(String type, String name, int size, String brand) {

        switch (CocktailType.parseCocktail(type)) {

            case HIBERNATION:
                return new Hibernation(name, size, brand);
            case MULLED_WINE:
                return new MulledWine(name, size, brand);
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_COCKTAIL_TYPE, type));
        }

    }

    private Delicacy getDelicacy(String type, String name, double price) {

        switch (DelicacyType.parseDelicacy(type)) {

            case GINGERBREAD:
                return new Gingerbread(name, price);
            case STOLEN:
                return new Stolen(name, price);
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_DELICACY_TYPE, type));
        }

    }

}
