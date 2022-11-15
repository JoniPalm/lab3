package se.iths.lab3_joni.model;

import javafx.scene.control.Label;

public enum BrushSize {
    TINY(10),
    SMALL(50),
    MEDIUM(85),
    LARGE(120),
    HUGE(160);

    private final int size;

    BrushSize(final int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
