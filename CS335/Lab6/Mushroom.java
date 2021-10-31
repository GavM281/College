package lab6;
/*
 *  Gavin Mulhern
 *  24/3/21
 */

public class Mushroom extends PizzaDecorator{
	private final Pizza pizza;
	
	public Mushroom(Pizza pizza){
		this.pizza = pizza;
	}

	@Override
	public String getDesc() {
		return pizza.getDesc()+", Mushroom (1.59)";
	}


	@Override
	public double getPrice() {
		return pizza.getPrice()+1.59;
	}
}
