package graph;

class FactoryProducer {
    static AbstractFactoryGraph getFactory(String choice) {

        if (choice.equalsIgnoreCase("EDGE")) {
            return new EdgeFactory();
        }
        return null;
    }
}