package se.iths.lab3_joni.model;

import javafx.scene.paint.Color;

import java.util.*;

public class DrawModel {
    public List<MyShape> shapes = new LinkedList<MyShape>();
    public BrushType brushType = BrushType.CIRCLE;
    public BrushSize brushSize = BrushSize.MEDIUM;

    public void setHugeBrush() {
        brushSize = BrushSize.HUGE;
    }

    public void setLargeBrush() {
        brushSize = BrushSize.LARGE;
    }

    public void setMediumBrush() {
        brushSize = BrushSize.MEDIUM;
    }

    public void setSmallBrush() {
        brushSize = BrushSize.SMALL;
    }

    public void setTinyBrush() {
        brushSize = BrushSize.TINY;
    }

    public void setCircleBrush() {
        brushType = BrushType.CIRCLE;
    }

    public void setSquareBrush() {
        brushType = BrushType.SQUARE;
    }
}
