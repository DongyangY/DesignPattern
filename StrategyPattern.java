/*
 * The Strategy Pattern defines a family of algorithms, encapsulates each one,
 * and make them interchangeable. Strategy lets the algorithm vary independently
 * from clients that use it.
 */

public class StrategyPattern {
    public static void main(String[] args) {
	MutableDuck md = new MutableDuck();
	md.performFly();
	md.setFlyBehavior(new FlyNoWay());
	md.performFly();
    }
}

abstract class Duck {
    FlyBehavior flyBehavior;

    public void performFly() {
	flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior fb) {
	flyBehavior = fb;
    }
}

class MutableDuck extends Duck {
    public MutableDuck() {
	flyBehavior = new FlyWithWings();
    }
}

interface FlyBehavior {
    public void fly();
}

class FlyWithWings implements FlyBehavior {
    public void fly() {
	System.out.println("I'm flying!");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
	System.out.println("I can't fly!");
    }
}
