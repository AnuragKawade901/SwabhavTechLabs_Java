package com.aurionpro.Builder.model;
class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    // Private constructor – only the builder can create
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public void showPizza() {
        System.out.println("Pizza size: " + size);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Mushrooms: " + mushrooms);
    }

    // Builder static inner class
    static class PizzaBuilder {
        private String size;  // required
        private boolean cheese;  // optional
        private boolean pepperoni;  // optional
        private boolean mushrooms;  // optional

        public PizzaBuilder(String size) {
            this.size = size;
        }

        public PizzaBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public PizzaBuilder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
public class BuilderExample {
	 public static void main(String[] args) {
	        // Build a medium pizza with cheese and mushrooms
	        Pizza myPizza = new Pizza.PizzaBuilder("Medium")
	                            .addCheese()
	                            .addMushrooms()
	                            .build();

	        myPizza.showPizza();
	    }
}
