package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private Shop shop;
    private int countCraftedPresents;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addHelper(String type, String helperName) {

        Helper newHelper = this.getHelper(type, helperName);
        this.helperRepository.add(newHelper);

        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        Helper helperByName = this.helperRepository.findByName(helperName);

        if (Objects.isNull(helperByName)) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        Instrument newInstrument = new InstrumentImpl(power);
        helperByName.addInstrument(newInstrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {

        Present newPresent = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(newPresent);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        Iterable<Helper> readyHelpers = this.helperRepository.getModels().stream().
                filter(helper -> helper.getEnergy() > 50).collect(Collectors.toList());

        if (!readyHelpers.iterator().hasNext()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        Present presentToCraft = this.presentRepository.findByName(presentName);

        int countBrokenInstruments = 0;

        for (Helper readyHelper : readyHelpers) {

            this.shop.craft(presentToCraft, readyHelper);

            int brokenInstruments = (int) readyHelper.getInstruments().stream().
                    filter(Instrument::isBroken).count();

            countBrokenInstruments += brokenInstruments;

            if (presentToCraft.isDone()) {
                this.countCraftedPresents++;
                break;
            }

        }

        String presentInfo = presentToCraft.isDone()
                ? String.format(ConstantMessages.PRESENT_DONE, presentName, "done")
                : String.format(ConstantMessages.PRESENT_DONE, presentName, "not done");

        String instrumentsInfo = String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS,
                countBrokenInstruments);

        return presentInfo.concat(instrumentsInfo);
    }

    @Override
    public String report() {

        StringBuilder report = new StringBuilder();

        report.append(String.format("%d presents are done!", this.countCraftedPresents));
        report.append(System.lineSeparator());

        report.append("Helpers info:");
        report.append(System.lineSeparator());

        this.helperRepository.getModels().forEach(helper -> {
            report.append(helper);
            report.append(System.lineSeparator());
        });

        return report.toString().trim();
    }

    private Helper getHelper(String type, String helperName) {

        switch (type) {

            case "Happy":
                return new Happy(helperName);
            case "Sleepy":
                return new Sleepy(helperName);
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }

    }

}
