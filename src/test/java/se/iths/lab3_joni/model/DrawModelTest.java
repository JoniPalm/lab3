package se.iths.lab3_joni.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawModelTest {
    DrawModel model = new DrawModel();
    
    @Test
    void CallingSetSmallBrush() {
        var expected = BrushSize.SMALL;
        model.setSmallBrush();
        var actual = model.brushSize;

        assertEquals(expected, actual);
    }
    
    @Test
    void CallingSetSquareBrush() {
        var expected = BrushType.SQUARE;
        model.setSquareBrush();
        var actual = model.brushType;

        assertEquals(expected, actual);
    }
}