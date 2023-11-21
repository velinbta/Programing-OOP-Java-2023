package fairyShop.models;

import java.util.Iterator;
import java.util.stream.Collectors;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        Iterable<Instrument> fitInstruments = helper.getInstruments().stream().filter(instrument ->
                !instrument.isBroken()).collect(Collectors.toList());

        Iterator<Instrument> iterator = fitInstruments.iterator();

        if (!helper.canWork() || !iterator.hasNext()) {
            return;
        }

        Instrument instrument = iterator.next();

        while (!present.isDone() && helper.canWork()) {

            helper.work();
            present.getCrafted();
            instrument.use();

            if (instrument.isBroken()) {

                iterator.remove();

                if (iterator.hasNext()) {
                    instrument = iterator.next();
                } else {
                    break;
                }

            }

        }

    }

}
