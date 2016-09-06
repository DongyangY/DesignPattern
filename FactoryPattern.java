abstract class PizzaStore {
    public Pizza orderPizza(String type) {
	Pizza pizza;
	pizza = createPizza(type);
	pizza.prepare();
	return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(String item) {
	if (item.equals("cheese")) {
	    return new NYStyleCheesePizza();
	} else return null;
    }
}

abstract class Pizza {
    protected String name;

    public void prepare() {
	System.out.println("Preparing " + name);
    }
}

class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
	name = "NY Cheese";
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
	PizzaStore nyStore = new NYPizzaStore();
	Pizza pizza = nyStore.orderPizza("cheese");
    }
}



