public interface Shape{
void draw();
}

public class Rectable implements Shape{

  @Override
    public void draw{
    System.out.println("Shape: Rectangle");
     }
}

public class Circle implements Shape{

  @Override
    public void draw{
    System.out.println("Shape: Circle");
     }
}

// Decorator class
public abstract class ShapeDecorator implemets Shape{

protected Shape decoratedShape;

  // constructor
  public ShapeDecorator(Shape decoratedShape){
  this.decoratedShape = decoratedShape;
  }
  
  public void draw(){
  decoratedShape.draw();
  }
 }
 
 public class RedShapeDecorator extends ShapeDecorator{
 
  // constructor
  public RedShapeDecorator(Shape decoratedShape){
  super(decoratedShape);
  }
  
   @Override
      public void draw(){
      decoratedShape.draw();
      setRedBorder(decoratedShape);// adding new functionality to existing object
      }
  
  private void setRedBorder(Shape decoratedShape){
      System.out.println("Border Color: Red");
   }
 }
 
 public class DecoratorDemo{
 
     public static void main(String[] args){

        Shape circle = new Circle();
        
        Shape redCircle = new RedShapeDecorator (new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
   }
}
 
