package fairyShop.models;

public class ShopImpl implements Shop{
    @Override
    public void craft(Present present, Helper helper) {
        for (Instrument instrument : helper.getInstruments()) {

            while(!instrument.isBroken() && helper.canWork()) {
                present.getCrafted();
                instrument.use();
                helper.work();
                if(present.isDone()){
                    break;
                }
            }

            if(present.isDone() || !helper.canWork()){
                break;
            }

        }

    }
}
