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
public class MoveShapeCommand implements Command {

    private Shape shape;
    private Canvas canvas;
    private int newX;
    private int newY;
    private int oldX;
    private int oldY;

    public MoveShapeCommand(Shape shape, Canvas canvas, int oldX, int oldY) {
        this.shape = shape;
        this.canvas = canvas;
        this.oldX = oldX;
        this.oldY = oldY;
    }

    @Override
    public void execute() {        // DO
        shape.alterShape(newX, newY, shape.getWidth(), shape.getHeight());
    }

    @Override
    public void unexecute() {   // UNDO
        shape.alterShape(oldX, oldY, shape.getWidth(), shape.getHeight());
    }

    public void setNewLocation(int x, int y) {
        newX = x;
        newY = y;
    }

}
