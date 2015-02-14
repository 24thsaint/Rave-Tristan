/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midpaint.commands;

import com.midpaint.objects.Canvas;
import com.midpaint.objects.Shape;
import java.awt.Color;

/**
 *
 * @author hero
 */
public class ChangeColorCommand implements Command {

    private Shape shape;
    private Canvas canvas;
    private Color newColor;
    private Color oldColor;

    public ChangeColorCommand(Shape shape, Canvas canvas, Color oldColor) {
        this.shape = shape;
        this.canvas = canvas;
        this.oldColor = oldColor;
    }

    public void setNewColor(Color newColor) {
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        canvas.getSelectedShape().setColor(newColor);
    }

    @Override
    public void unexecute() {
        canvas.getSelectedShape().setColor(oldColor);
    }

}
