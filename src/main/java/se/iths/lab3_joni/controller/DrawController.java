package se.iths.lab3_joni.controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import se.iths.lab3_joni.model.BrushSize;
import se.iths.lab3_joni.model.DrawModel;

public class DrawController {
    public Label sizeLabel;
    GraphicsContext context;
    public Canvas canvas;

    DrawModel model = new DrawModel();

    public void initialize() {
        context = canvas.getGraphicsContext2D();
    }

    public void onNewClicked() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //Todo: Add popup-question before clearing.
    }

    public void onSaveClicked() {
        //Todo: Save svg.
    }

    public void onQuitClicked() {
        System.exit(0);
    }

    public void onCanvasClick(MouseEvent mouseEvent) {
        context.setFill(model.color);
        switch (model.brushType) {
            case CIRCLE -> context.fillOval(mouseEvent.getX() - (model.brushSize.getSize() / 2),
                    mouseEvent.getY() - (model.brushSize.getSize() / 2),
                    model.brushSize.getSize(),
                    model.brushSize.getSize());
            case TRIANGLE -> context.fillRect(mouseEvent.getX() - (model.brushSize.getSize() / 2),
                    mouseEvent.getY() - (model.brushSize.getSize() / 2),
                    model.brushSize.getSize(),
                    model.brushSize.getSize());
            case SQUARE -> context.fillRect(mouseEvent.getX() - (model.brushSize.getSize() / 2),
                    mouseEvent.getY() - (int) (model.brushSize.getSize() / 2),
                    model.brushSize.getSize(),
                    model.brushSize.getSize());
            case LINE -> context.fillRect(mouseEvent.getX() - (int) (model.brushSize.getSize() / 2),
                    mouseEvent.getY() - (int) (model.brushSize.getSize() / 2),
                    model.brushSize.getSize(),
                    model.brushSize.getSize());
        }
    }

    public void increaseBrushSize() {
        if (model.brushSize == BrushSize.LARGE) {
            model.brushSize = BrushSize.HUGE;
            sizeLabel.setText("HUGE");
        } else if (model.brushSize == BrushSize.MEDIUM) {
            model.brushSize = BrushSize.LARGE;
            sizeLabel.setText("LARGE");
        } else if (model.brushSize == BrushSize.SMALL) {
            model.brushSize = BrushSize.MEDIUM;
            sizeLabel.setText("MEDIUM");
        } else if (model.brushSize == BrushSize.TINY) {
            model.brushSize = BrushSize.SMALL;
            sizeLabel.setText("SMALL");
        }
    }

    public void decreaseBrushSize() {
            if (model.brushSize == BrushSize.SMALL) {
                model.brushSize = BrushSize.TINY;
                sizeLabel.setText("TINY");
            } else if (model.brushSize == BrushSize.MEDIUM) {
                model.brushSize = BrushSize.SMALL;
                sizeLabel.setText("SMALL");
            } else if (model.brushSize == BrushSize.LARGE) {
                model.brushSize = BrushSize.MEDIUM;
                sizeLabel.setText("MEDIUM");
            } else if (model.brushSize == BrushSize.HUGE) {
                model.brushSize = BrushSize.LARGE;
                sizeLabel.setText("LARGE");
        }
    }
}