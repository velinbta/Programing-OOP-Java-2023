package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool {

    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {

        int decreasedPower = this.getPower() - 5;

        try {
            this.setPower(decreasedPower);
        } catch (IllegalArgumentException e) {
            this.setPower(0);
        }

    }

    @Override
    public boolean isUnfit() {
        return this.getPower() == 0;
    }

}
