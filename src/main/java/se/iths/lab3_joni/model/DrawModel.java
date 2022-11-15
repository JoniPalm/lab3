package se.iths.lab3_joni.model;

import javafx.scene.paint.Color;

import java.util.*;

public class DrawModel {
    public List<MyShape> shapes = new LinkedList<MyShape>();
    public BrushType brushType = BrushType.CIRCLE;
    public BrushSize brushSize = BrushSize.MEDIUM;
}
