package plugs;
/**
* @author Gavin Mulhern
* @since 17 Feb 2021
*/
public class FurutechPlug implements UKPlugConnector {
	public void provideElectricity(){
        System.out.println("Giving electricity to a Furutech plug.");
    }
}
