/*
 * The Template Method Pattern defines the skeleton of an algorithm in a method, deferring
 * some steps to subclasses. Template Method lets subclasses redefine certain steps of an
 * algorithm without changing the algorithms' structure.
 */

abstract class CaffeineBeverage {
    final void prepareRecipe() {
	boilWater();
	brew();
	pourInCup();
	addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
	
    }

    void pourInCup() {

    }
}

class Tea extends CaffeineBeverage {
    public void brew() {

    }

    public void addCondiments() {

    }
}

class Coffee extends CaffeineBeverage {
    public void brew() {

    }

    public void addCondiments() {

    }
}
