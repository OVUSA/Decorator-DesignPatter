public class Animal {
    private String name ;
    private double speed;
    private String sound;

    public Flies flyType;


    public void setName (String name){
        this.name = name;
    }
    public void setSpeed (double speed){
        this.speed = speed;
    }
    public void setSound (String sound){
        this.sound = sound;
    }

    public String tryToFly(){
        return flyType.fly();
    }
    //The method allows to change thr flying type dynamically.
    public void setAbilityToFly(Flies newflyType){
        flyType = newflyType;
    }




}
