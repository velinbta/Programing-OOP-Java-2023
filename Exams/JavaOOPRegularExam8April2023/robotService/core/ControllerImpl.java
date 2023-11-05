package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.Repository;
import robotService.repositories.SupplementRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
public class ControllerImpl implements Controller {

    private Repository supplements;
    private Map<String, Service> servicesByName;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.servicesByName = new LinkedHashMap<>();
    }

    @Override
    public String addService(String type, String name) {

        Service newService = getServiceByTypeOrNull(type, name);

        if (Objects.isNull(newService)) {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }

        this.servicesByName.putIfAbsent(name, newService);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {

        Supplement newSupplement = getSupplementByTypeOrNull(type);

        if (Objects.isNull(newSupplement)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        this.supplements.addSupplement(newSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {

        Supplement foundSupplement = this.supplements.findFirst(supplementType);

        if (Objects.isNull(foundSupplement)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        this.servicesByName.get(serviceName).addSupplement(foundSupplement);
        this.supplements.removeSupplement(foundSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {

        Robot newRobot = getRobotByTypeOrNull(robotType, robotName, robotKind, price);

        if (Objects.isNull(newRobot)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }

        Service neededService = this.servicesByName.get(serviceName);

        boolean isSuitable = checkSuitable(neededService, robotType);

        if (!isSuitable) {
            return ExceptionMessages.UNSUITABLE_SERVICE;
        }

        neededService.addRobot(newRobot);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {

        Service service = this.servicesByName.get(serviceName);
        service.feeding();

        return String.format(ConstantMessages.FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {

        double robotPrice = this.servicesByName.values().stream().map(Service::getRobots).
                reduce(0D, (subtotal, element) -> subtotal + element.stream().
                        mapToDouble(Robot::getPrice).sum(), Double::sum);

        double supplementPrice = this.servicesByName.values().stream().map(Service::getSupplements).
                reduce(0D, (subtotal, element) -> subtotal + element.stream().
                        mapToDouble(Supplement::getPrice).sum(), Double::sum);

        double total = robotPrice + supplementPrice;

        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, total);
    }

    @Override
    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();

        this.servicesByName.values().stream().map(Service::getStatistics).forEach(stat -> {
            statistics.append(stat);
            statistics.append(System.lineSeparator());
        });

        return statistics.toString().trim();
    }

    private boolean checkSuitable(Service neededService, String robotType) {

        String serviceType = neededService.getClass().getSimpleName();

        return serviceType.equals("SecondaryService") && robotType.equals("FemaleRobot") ||
                serviceType.equals("MainService") && robotType.equals("MaleRobot");

    }

    private Supplement getSupplementByTypeOrNull(String type) {

        switch (type) {
            case "PlasticArmor":
                return new PlasticArmor();
            case "MetalArmor":
                return new MetalArmor();
            default:
                return null;
        }

    }

    private Robot getRobotByTypeOrNull(String robotType, String robotName, String robotKind, double price) {

        switch (robotType) {
            case "MaleRobot":
                return new MaleRobot(robotName, robotKind, price);
            case "FemaleRobot":
                return new FemaleRobot(robotName, robotKind, price);
            default:
                return null;
        }

    }

    private Service getServiceByTypeOrNull(String type, String name) {

        switch (type) {
            case "MainService":
                return new MainService(name);
            case "SecondaryService":
                return new SecondaryService(name);
            default:
                return null;
        }

    }

}
