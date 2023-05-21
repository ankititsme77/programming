// Step 1: Define an interface or abstract class for the product
interface Product {
    void doSomething();
}

// Step 2: Create concrete classes implementing the Product interface
class ConcreteProductA implements Product {
    @Override
    public void doSomething() {
        System.out.println("Doing something in ConcreteProductA");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void doSomething() {
        System.out.println("Doing something in ConcreteProductB");
    }
}

// Step 3: Create a factory class to create instances of the product
class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equalsIgnoreCase("A")) {
            return new ConcreteProductA();
        } else if (type.equalsIgnoreCase("B")) {
            return new ConcreteProductB();
        }
        throw new IllegalArgumentException("Invalid product type: " + type);
    }
}

// Step 4: Use the factory class to create objects
public class Main {
    public static void main(String[] args) {
        // Create a ConcreteProductA instance
        Product productA = ProductFactory.createProduct("A");
        productA.doSomething();

        // Create a ConcreteProductB instance
        Product productB = ProductFactory.createProduct("B");
        productB.doSomething();
    }
}
