// a visitor class.Instances represent fucntions from Shape to a generic result type.

public interface Visitor<Result>{
    Result onCircle(Circle c);
    Result onRectangle(Rectangle r);
    Result onGroup(Group g);
    Result onStrokeColor(StrokeColor c);
    Result onFill(Fill c);
    Result onLocation(Location c);
    Result onOutline(Outline o);
    Result onPolygon(Polygon p);

}


public interface Shape {
    <Result> Result accept(Visitor<Result> v);
  }


public class Rectangle implements Shape {

    protected final int width, height;

    public Rectangle(final int width, final int height) {
      assert width >= 0;
      assert height >= 0;
      this.width = width;
      this.height = height;
    }

    public int getWidth() {
      return width;
    }

    public int getHeight() {
      return height;
    }

    @Override
    public <Result> Result accept(final Visitor<Result> v) {
      return v.onRectangle(this);
    }
}

public class Circle implements Shape {

    protected final int radius;

    public Circle(final int radius) {
      assert radius >= 0;
      this.radius = radius;
    }

    public int getRadius() {
      return radius;
    }

    @Override
    public <Result> Result accept(final Visitor<Result> v) {
      return v.onCircle(this);
    }
}

public class Polygon extends Group {

    public Polygon(final Point... points) {
      super(points);
    }

    @SuppressWarnings("unchecked")
    public List<? extends Point> getPoints() {
      return (List<? extends Point>) getShapes();
    }

    @Override
    public <Result> Result accept(final Visitor<Result> v) {
      return v.onPolygon(this);

    }
}


public class StrokeColor implements Shape {
	public final Shape shape;
	public final int color;


	public StrokeColor(final int color, final Shape shape) {
		this.shape = shape;
		this.color = color;
	}

	public int getColor(){
		return color;
	}

	public Shape getShape() {
		return shape;
	}

	@Override
	public <Result> Result accept(Visitor<Result> v) {
		return v.onStrokeColor(this);
	}
}


public class Point extends Location {
	private static final Shape point = new Circle(0);

	public Point(final int x, final int y) {
		super(-1, -1, null);
		assert x >= 0;
		assert y >= 0;
	}
}


public class Outline implements Shape {

	protected final Shape shape;

	public Outline(final Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	@Override
	public <Result> Result accept(final Visitor<Result> v) {

		return v.onOutline(this);
	}
}


/**
 * A decorator for specifying a shape's location.
 */
public class Location implements Shape {

	protected final int x, y;

	protected final Shape shape;

	public Location(final int x, final int y, final Shape shape) {
		this.x = x;
		this.y = y;
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return v.onLocation(this);
	}
}


/**
 * A composite for grouping edu.luc.etl.cs313.android.shapes.model.
 */
public class Group implements Shape {

	protected final List<? extends Shape> shapes;

	public Group(final Shape... shapes) {
		this.shapes = Arrays.asList(shapes);
	}

	public List<? extends Shape> getShapes() {
		return Collections.unmodifiableList(shapes);
	}

	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return v.onGroup(this);
	}

}


**
 * Test fixtures shared across test cases.
 */
public class Fixtures {

	private Fixtures() { /* prevent instantiation! */ }

	public static final Shape simpleCircle = new Circle(50);

	public static final Shape simpleLocation = new Location(70, 30, new Rectangle(80, 120));

	public static final Shape simpleFill = new Fill(new Rectangle(80, 120));

	public static final Shape simpleStrokeColor = new StrokeColor(Color.RED, new Rectangle(80, 120));

	public static final Shape simpleGroup = new Group(
		new Location(200, 100, new Circle(50)),
		new Location(400, 300, new Rectangle(100, 50))
	);

	public static final Shape middleGroup = new Location(50, 100,
		new Group(
			new Outline(new Rectangle(50, 30)),
			new Group(
				new Circle(20),
				new Rectangle(50, 30)
			)
		)
	);

	public static final Shape complexGroup = new Location(50, 100,
		new Group(
			new Circle(20),
			new Rectangle(100, 200),
			new Location(150, 50,
				new StrokeColor(Color.RED,
					new Fill(
						new Group(
							new Rectangle(50, 30),
							new Outline(new Rectangle(300, 60)),
				  			new StrokeColor(Color.BLUE,
				  				new Polygon(
				  					new Point(50, 50),
				  					new Point(60, 100),
				  					new Point(100, 110),
				  					new Point(120, 60)
				  				)
				  			),
							new Location(100, 200,
								new StrokeColor(Color.MAGENTA,
									new Outline(new Circle(50))
								)
							)
						)
					)
				)
			)
		)
	);

	public static final Shape simpleOutline = new Outline(new Rectangle(80, 120));

	public static final Shape simplePolygon = new Polygon(
		new Point(50, 50),
		new Point(60, 100),
		new Point(100, 110),
  		new Point(120, 60)
	);
}

/**
 * A decorator indicating that a shape should be drawn as a filled shape instead
 * of an outlined one.
 */
public class Fill implements Shape {

	protected final Shape shape;

	public Fill(final Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	@Override
	public <Result> Result accept(final Visitor<Result> v) {

		return v.onFill(this);
	}
}
