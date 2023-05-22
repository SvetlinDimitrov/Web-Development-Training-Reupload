package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {
    public AnimalExplorer(String name) {
        super(name, 100);
    }

    @Override
    public void search() {
        double currentEnergy = getEnergy();

        if(currentEnergy - 15 < 0){
            setEnergy(0);
            return;
        }
        setEnergy(currentEnergy-15);
    }
}
