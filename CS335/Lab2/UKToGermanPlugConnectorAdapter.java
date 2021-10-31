package plugs;
/**
* @author Gavin Mulhern
* @since 17 Feb 2021
*/
public class UKToGermanPlugConnectorAdapter implements GermanPlugConnector{
	private UKPlugConnector plug;
	
    public UKToGermanPlugConnectorAdapter(UKPlugConnector plug) {
        this.plug = plug;
    }
    
    @Override
    public void giveElectricity() {
        plug.provideElectricity();
    }
}