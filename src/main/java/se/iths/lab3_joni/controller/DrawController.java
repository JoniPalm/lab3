package se.iths.lab3_joni.controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import se.iths.lab3_joni.model.BrushSize;
import se.iths.lab3_joni.model.BrushType;
import se.iths.lab3_joni.model.DrawModel;
import se.iths.lab3_joni.model.MyShape;

public class DrawController {
    public Label sizeLabel;
    public ColorPicker colorPicker;
    GraphicsContext context;
    public Canvas canvas;

    DrawModel model = new DrawModel();

    public void initialize() {
        context = canvas.getGraphicsContext2D();
    }

    public void onNewClicked() {
        clearCanvas();
        //Todo: Add popup-question before clearing.
    }

    private void clearCanvas() {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void onSaveClicked() {
        //Todo: Save svg.
    }

    public void onQuitClicked() {
        System.exit(0);
    }

    public void onCanvasClick(MouseEvent mouseEvent) {
        context.setFill(colorPicker.getValue());
        switch (model.brushType) {
            case CIRCLE -> {
                context.fillOval(mouseEvent.getX() - (model.brushSize.getSize() / 2),
                        mouseEvent.getY() - (model.brushSize.getSize() / 2),
                        model.brushSize.getSize(),
                        model.brushSize.getSize());

                MyShape shape = new MyShape((int) (mouseEvent.getX()), (int) (mouseEvent.getY()), model.brushSize, BrushType.CIRCLE, colorPicker.getValue());
                model.shapes.add(shape);
            }
            case SQUARE -> {
                context.fillRect(mouseEvent.getX() - (model.brushSize.getSize() / 2),
                        mouseEvent.getY() - (model.brushSize.getSize() / 2),
                        model.brushSize.getSize(),
                        model.brushSize.getSize());

                MyShape shape = new MyShape((int) (mouseEvent.getX()), (int) (mouseEvent.getY()), model.brushSize, BrushType.SQUARE, colorPicker.getValue());
                model.shapes.add(shape);
            }
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

    public void onCirclePicked() {
        model.brushType = BrushType.CIRCLE;
    }
    public void onSquarePicked() {
        model.brushType = BrushType.SQUARE;
    }

    public void onUndoClicked(ActionEvent actionEvent) {
        if (!model.shapes.isEmpty()) {
            model.shapes.remove(model.shapes.size() - 1);

            clearCanvas();

            if (!model.shapes.isEmpty())
                model.shapes.forEach(shape -> reDraw(shape));
        }
    }

    private void reDraw(MyShape shape) {
        context.setFill(shape.color);
        switch(shape.shape) {
            case CIRCLE -> context.fillOval(shape.x - (shape.size.getSize() / 2),
                    shape.y - (shape.size.getSize() / 2),
                    shape.size.getSize(),
                    shape.size.getSize());
            case SQUARE -> context.fillRect(shape.x - (shape.size.getSize() / 2),
                    shape.y - (shape.size.getSize() / 2),
                    shape.size.getSize(),
                    shape.size.getSize());
        }
    }
}