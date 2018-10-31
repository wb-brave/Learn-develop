package thinkinjava.chapter18.serializable;

import util.MyConst;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.serializable
 * @email wubin326@qq.com
 * @date 2018/10/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/23        wubin            0.0.1
 */
public class StoreCADState {
    public static void main(String[] args) throws IOException {
        ArrayList<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        /**
         * 将每个类的引用关联
         */
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);
        ArrayList<Shape> shapes = new ArrayList<>();
        //生成多个shape
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }

        for (int i = 0; i < 10; i++) {
            ((Shape)shapes.get(i)).setColor(Shape.GREEN);
        }

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(MyConst.FileConst.FILEPATH_DESKTOP + "CADState.out"));
        objectOutputStream.writeObject(shapeTypes);
        /**
         * 因为line中有这个方法，
         * 所以必须在序列化输出的时候
         * 手动调用
         */
        Line.serializeStaticState(objectOutputStream);
        Circle.serializeStaticState(objectOutputStream);
        Square.serializeStaticState(objectOutputStream);
        objectOutputStream.writeObject(shapes);
        System.out.println(shapes);

    }
}

abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int count = 0;

    public abstract void setColor(int neeColor);

    public abstract int getColor();

    public Shape() {
    }

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + " Shape{" +
                "color[" + getColor() +
                "] xPos=" + xPos +
                ", yPos=" + yPos +
                ", dimension=" + dimension +
                '}' + "\n";
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (count++ % 3) {
            // 默认不做什么的时候，不能放在最后一层
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }
}

class Circle extends Shape {
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int neeColor) {
        color = neeColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }
    /**
     * 因为color是静态变量且在构造方法中赋值的，所以在反序列化的时候
     * 输出的值为0
     * 如果不是静态变量的化则没有影响
     * @param xPos
     * @param yPos
     * @param dimension
     */
    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    @Override
    public void setColor(int neeColor) {
        color = neeColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line extends Shape {
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int neeColor) {
        color = neeColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}