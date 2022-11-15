package se.iths.lab3_joni.model;

import javafx.scene.paint.Color;

import java.util.*;

public class DrawModel {
    List<MyShape> drawing = new LinkedList<MyShape>();
    public BrushType brushType = BrushType.CIRCLE;
    public BrushSize brushSize = BrushSize.MEDIUM;
    public Color color = Color.BLACK;
}
