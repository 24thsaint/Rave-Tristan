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
public class DeleteShapeCommand implements Command{

    private Shape shape;
    private Canvas canvas;

    public DeleteShapeCommand(Shape shape, Canvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }
    
    @Override
    public void execute() {
        this.canvas.removeShape(shape);
    }

    @Override
    public void unexecute() {
        this.canvas.addShape(shape);
    }
    
}
