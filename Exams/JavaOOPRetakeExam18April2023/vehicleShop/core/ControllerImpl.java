package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository<Worker> workerRepository;
    private Repository<Vehicle> vehicleRepository;
    private Shop shop;
    private int readyVehicles;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {

        Worker newWorker = getWorkerByTypeOrNull(type, workerName);

        if (Objects.isNull(newWorker)) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }

        this.workerRepository.add(newWorker);

        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {

        Vehicle newVehicle = new VehicleImpl(vehicleName, strengthRequired);

        this.vehicleRepository.add(newVehicle);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {

        Worker workerByName = this.workerRepository.findByName(workerName);

        if (Objects.isNull(workerByName)) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        Tool newTool = new ToolImpl(power);

        workerByName.addTool(newTool);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {

        Vehicle vehicleByName = this.vehicleRepository.findByName(vehicleName);

        Worker currentWorker = getWorkerAbove70UnitOrNull();

        if (Objects.isNull(currentWorker)) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        int unfitCount = 0;
        while (Objects.nonNull(currentWorker)) {

            this.shop.make(vehicleByName, currentWorker);

            unfitCount += currentWorker.getTools().stream().filter(Tool::isUnfit).count();

            if (vehicleByName.reached()) {
                this.readyVehicles++;
                this.vehicleRepository.remove(vehicleByName);
                break;
            }

            currentWorker = getWorkerAbove70UnitOrNull();
        }

        String vehicleResult = vehicleByName.reached()
                ? String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "done")
                : String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "not done");

        String toolsResult = String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, unfitCount);

        return vehicleResult + toolsResult;
    }

    private Worker getWorkerAbove70UnitOrNull() {

        for (Worker worker : this.workerRepository.getWorkers()) {
            if (worker.getStrength() > 70) {
                return worker;
            }
        }

        return null;
    }

    private Worker getWorkerByTypeOrNull(String workerType, String workerName) {

        switch (workerType) {
            case "FirstShift":
                return new FirstShift(workerName);
            case "SecondShift":
                return new SecondShift(workerName);
            default:
                return null;
        }

    }

    @Override
    public String statistics() {

        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format("%d vehicles are ready!", this.readyVehicles));
        statistics.append(System.lineSeparator());

        statistics.append("Info for workers:");
        statistics.append(System.lineSeparator());

        for (Worker worker : this.workerRepository.getWorkers()) {

            statistics.append(String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength()));
            statistics.append(System.lineSeparator());

            int fitTools = (int) worker.getTools().stream().filter(t -> !t.isUnfit()).count();

            statistics.append(String.format("Tools: %d fit left", fitTools));
            statistics.append(System.lineSeparator());

        }

        return statistics.toString().trim();
    }

}
