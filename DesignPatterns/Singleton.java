
//lazyInitialization

// Database connection, Logging, Caching , Configuration
class Engine {

    private Engine engine  ;

    //Constructor is private
    private Engine (){};

   //static method is used to create instance in synchronized block
    public static Engine getInstance(){
        if(engine == null){
            synchronized(Engine.class){
                if(engine == null)
                    engine = new Engine();
            }
        }
        return engine;
    }
}