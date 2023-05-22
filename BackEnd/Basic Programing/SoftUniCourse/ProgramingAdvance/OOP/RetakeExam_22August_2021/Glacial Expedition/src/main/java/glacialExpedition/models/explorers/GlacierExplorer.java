package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{

    public GlacierExplorer(String name) {
        super(name, 40);
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
