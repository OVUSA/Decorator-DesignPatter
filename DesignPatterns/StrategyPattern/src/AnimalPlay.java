public class AnimalPlay {

    public static void main(String[] args){

        Animal toto = new Dog();
        Animal bird = new Bird();



        System.out.println("Dog "+ toto.tryToFly());
        System.out.println("Bird "+ bird.tryToFly());

        // This allows dynamic changes for flyingType

        toto.setAbilityToFly(new ItFlies());
        System.out.println("Dog "+ toto.tryToFly());
    }
}
