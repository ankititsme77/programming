class Pizza{

    String base;

    List<String> toppings;



    Pizaa(){}

    Pizza(Builder builder){

        this.base= builder.base;

        this.toppings = builder.topings;

    }


    static class Builder{

        String base;

        List<String> toppings;


        public static Builder withBase(String base){

            this.base= base;
            this.toppings = new ArrayList<String>();
            return this;


        }

        public static Builder withToppings(String topping){

            this.toppings= topping;

            return this;


        }

        public static Builder build(){

            return new Pizza(this);
        }

    }


}