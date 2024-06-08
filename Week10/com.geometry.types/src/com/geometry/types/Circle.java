package com.geometry.types;

public class Circle extends Point{
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    public Circle(){
        this(0, 0, 1);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if(radius > 0) {
            this.radius = radius;
        }else{
            this.radius = 1;
        }
    }

    @Override
    public int compareTo(Object o) {
        if( o == null) return  1;
        if( !(o instanceof Circle)) return 1;
        Circle c = (Circle) o;
        int centerCompare = super.compareTo(c);
        if(centerCompare != 0)
            return centerCompare;

        return this.radius - c.radius;
    }

    @Override
    public String toString() {
        return String.format("Circle %s," +
                "radius = %d",
                super.toString(), radius);
    }
}
