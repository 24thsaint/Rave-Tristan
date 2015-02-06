/*
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 *  |      CENTRAL PHILIPPINE UNIVERSITY                   |
 *  |      Bachelor of Science in Software Engineering     |
 *  |      Jaro, Iloilo City, Philippines                  |
 *  |                                                      |
 *  |          This program is written by Rave, ©2015.     |
 *  |          You are free to use and distribute this.    |
 *  |          Reach me at: admin@blackout.biz.tm          |
 *  |                                                      |
 *  |               ~~~"CODE the FUTURE"~~~                |
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 */
package com.midpaint.commands;

import com.midpaint.objects.Canvas;
import com.midpaint.objects.Shape;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class DrawShapeCommand implements Command {

    private Shape shape;
    private Canvas canvas;

    public DrawShapeCommand(Shape shape, Canvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        this.canvas.addShape(shape);
    }

    @Override
    public void unexecute() {
        this.canvas.removeShape(shape);
    }
}
