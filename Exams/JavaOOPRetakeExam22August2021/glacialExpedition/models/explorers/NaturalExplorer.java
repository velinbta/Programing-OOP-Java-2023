package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double INITIAL_ENERGY = 60D;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        double decreasedEnergy = this.getEnergy() - 7;
        this.setEnergy(Math.max(decreasedEnergy, 0));
    }

}
