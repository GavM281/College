package lab6;
/*
 *  Gavin Mulhern
 *  24/3/21
 */

public class Pineapple extends PizzaDecorator{
	private final Pizza pizza;
	
	public Pineapple(Pizza pizza){
		this.pizza = pizza;
	}

	@Override
	public String getDesc() {
		return pizza.getDesc()+", Pineapple (2.83)";
	}


	@Override
	public double getPrice() {
		return pizza.getPrice()+2.83;
	}
}
