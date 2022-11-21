package se.iths.lab3_joni.controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

    public void onCanvasClick(MouseEvent event) {
        MyShape myShape;

        if (event.isControlDown()) {
            if (!model.shapes.isEmpty())
                checkListForHits(event.getX(), event.getY());
        } else {
            context.setFill(colorPicker.getValue());
            switch (model.brushType) {
                case CIRCLE -> {
                    context.fillOval(event.getX() - (model.brushSize.getSize() / 2),
                            event.getY() - (model.brushSize.getSize() / 2),
                            model.brushSize.getSize(),
                            model.brushSize.getSize());

                    myShape = new MyShape((int) (event.getX()), (int) (event.getY()), model.brushSize, BrushType.CIRCLE, colorPicker.getValue());
                    model.shapes.add(myShape);
                }
                case SQUARE -> {
                    context.fillRect(event.getX() - (model.brushSize.getSize() / 2),
                            event.getY() - (model.brushSize.getSize() / 2),
                            model.brushSize.getSize(),
                            model.brushSize.getSize());

                    myShape = new MyShape((int) (event.getX()), (int) (event.getY()), model.brushSize, BrushType.SQUARE, colorPicker.getValue());
                    model.shapes.add(myShape);
                }
            }
        }
    }

    private void checkListForHits(double x, double y) {
        boolean hit = false;

        for (int i = 0; i < model.shapes.size(); i++) {
            MyShape shape = model.shapes.get(i);
            float sx = shape.x;    // square position
            float sy = shape.y;
            float sw = shape.size.getSize();    // and dimensions
            float sh = shape.size.getSize();;


            if (x >= sx &&        // right of the left edge AND
                    x <= sx + sw &&   // left of the right edge AND
                    y >= sy &&        // below the top AND
                    y <= sy + sh) {   // above the bottom

                MyShape newShape = new MyShape(shape.x, shape.y, model.brushSize, model.brushType, colorPicker.getValue());
                model.shapes.remove(shape);
                model.shapes.add(newShape);
                hit = true;
                break;
            }
        }

        if (hit) {
            clearCanvas();
            model.shapes.forEach(this::reDraw);
        }


    }

    public void onIncreaseButtonPress() {
        if (model.brushSize == BrushSize.LARGE) {
            model.setHugeBrush();
            sizeLabel.setText("HUGE");
        } else if (model.brushSize == BrushSize.MEDIUM) {
            model.setLargeBrush();
            sizeLabel.setText("LARGE");
        } else if (model.brushSize == BrushSize.SMALL) {
            model.setMediumBrush();
            sizeLabel.setText("MEDIUM");
        } else if (model.brushSize == BrushSize.TINY) {
            model.setSmallBrush();
            sizeLabel.setText("SMALL");
        }
    }

    public void onDecreaseButtonPress() {
        if (model.brushSize == BrushSize.SMALL) {
            model.setTinyBrush();
            sizeLabel.setText("TINY");
        } else if (model.brushSize == BrushSize.MEDIUM) {
            model.setSmallBrush();
            sizeLabel.setText("SMALL");
        } else if (model.brushSize == BrushSize.LARGE) {
            model.setMediumBrush();
            sizeLabel.setText("MEDIUM");
        } else if (model.brushSize == BrushSize.HUGE) {
            model.setLargeBrush();
            sizeLabel.setText("LARGE");
        }
    }

    public void onCirclePicked() {
        model.setCircleBrush();
    }
    public void onSquarePicked() {
        model.setSquareBrush();
    }

    public void onUndoClicked(ActionEvent actionEvent) {
        if (!model.shapes.isEmpty()) {
            model.shapes.remove(model.shapes.size() - 1);

            clearCanvas();

            if (!model.shapes.isEmpty())
                model.shapes.forEach(this::reDraw);
        }
    }

    private void reDraw(MyShape shape) {
        context.setFill(shape.color);
        switch (shape.brushType) {
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