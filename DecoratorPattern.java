/*
 * The Decorator Pattern attaches additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending functionality.
 */

abstract class Beverage {
    String description = "";

    public String getDescription() {
	return description;
    }

    public abstract double cost();
}

class Espresso extends Beverage {
    public Espresso() {
	description = "Espresso";
    }

    public double cost() {
	return 1.99;
    }
}

// Extends Beverage so can be wrapped by another Decorator 
abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
	this.beverage = beverage;
    }

    public String getDescription() {
	return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
	return .20 + beverage.cost();
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
	Beverage beverage = new Espresso();
	beverage = new Mocha(beverage);
	System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
