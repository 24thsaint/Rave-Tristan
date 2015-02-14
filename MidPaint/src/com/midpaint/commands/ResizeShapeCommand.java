/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midpaint.commands;

import com.midpaint.objects.Canvas;
import com.midpaint.objects.Shape;

/**
 *
 * @author hero
 */
public class ResizeShapeCommand implements Command {

    private Shape shape;
    private Canvas canvas;
    private int oldX;
    private int oldY;
    private int oldWidth;
    private int oldHeight;
    private int newX;
    private int newY;
    private int newWidth;
    private int newHeight;

    public ResizeShapeCommand(Shape shape, Canvas canvas, int oldX, int oldY, int oldWidth, int oldHeight) {
        this.shape = shape;
        this.canvas = canvas;
        this.oldX = oldX;
        this.oldY = oldY;
        this.oldWidth = oldWidth;
        this.oldHeight = oldHeight;
    }

    public void setNewShapeParameters(int newX, int newY, int newHeight, int newWidth) {
        this.newX = newX;
        this.newY = newY;
        this.newHeight = newHeight;
        this.newWidth = newWidth;
    }

    @Override
    public void execute() {
        shape.alterShape(newX, newY, newWidth, newHeight);
    }

    @Override
    public void unexecute() {
        shape.alterShape(oldX, oldY, oldWidth, oldHeight);
    }

}
