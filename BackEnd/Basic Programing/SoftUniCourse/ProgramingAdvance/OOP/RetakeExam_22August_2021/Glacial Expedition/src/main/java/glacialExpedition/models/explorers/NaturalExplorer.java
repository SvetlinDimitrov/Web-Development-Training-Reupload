package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    public NaturalExplorer(String name) {
        super(name, 60);
    }

    @Override
    public void search() {
        double currentEnergy = getEnergy();
        if(currentEnergy - 7 < 0){
            setEnergy(0);
        }
        setEnergy(currentEnergy-7);
    }
}
