package se.iths.lab3_joni.model;

import javafx.scene.paint.Color;

public class MyShape {
    public int x;
    public int y;
    public BrushSize size;

    public BrushType shape;
    public Color color;

    public MyShape(int x, int y, BrushSize size, BrushType shape, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.shape = shape;
        this.color = color;

    }
}
