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
    private Color newColor;
    private Color oldColor;

    public ChangeColorCommand(Shape shape,
            Color oldColor,
            Color newColor) {
        this.shape = shape;
        this.oldColor = oldColor;
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        shape.setColor(newColor);
    }

    @Override
    public void unexecute() {
        shape.setColor(oldColor);
    }

}
