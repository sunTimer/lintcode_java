/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
        char a = 'd';
        new String(a+"");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");

    }
}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        Shape shape = null;
        switch (shapeType){
            case "Triangle":
                shape = new Triangle();
                break;
            case "Square" :
                shape = new Square();
                break;
            case  "Rectangle":
                shape = new  Rectangle();
                break;
        }
        return shape;
    }
}