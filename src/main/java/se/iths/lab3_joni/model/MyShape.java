package se.iths.lab3_joni.model;

import javafx.scene.paint.Color;

public class MyShape {
    public int x;
    public int y;
    public BrushSize size;

    public BrushType brushType;
    public Color color;

    public MyShape(int x, int y, BrushSize size, BrushType brushType, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.brushType = brushType;
        this.color = color;
    }
}
