package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;
import java.util.Objects;

public class ShopImpl implements Shop {

    @Override
    public void make(Vehicle vehicle, Worker worker) {

        Collection<Tool> tools = worker.getTools();

        Tool currentTool = getNextFitToolOrNull(tools);

        while (worker.canWork() && Objects.nonNull(currentTool)) {

            worker.working();
            vehicle.making();
            currentTool.decreasesPower();

            if (vehicle.reached()) {
                break;
            }

            if (currentTool.isUnfit()) { // <- next
                currentTool = getNextFitToolOrNull(tools);
            }

        }

    }

    private Tool getNextFitToolOrNull(Collection<Tool> tools) {

        for (Tool tool : tools) {
            if (!tool.isUnfit()) {
                return tool;
            }
        }

        return null;
    }

}
