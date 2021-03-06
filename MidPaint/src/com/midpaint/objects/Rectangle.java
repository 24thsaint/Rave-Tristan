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
package com.midpaint.objects;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class Rectangle extends Shape {

    public Rectangle(int x, int y, int height, int width) {
        super(x, y, height, width);
        setColor(Color.BLUE);
    }

    public Rectangle(int x, int y) {
        super(x, y, 10, 10);
        setColor(Color.BLACK);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(x, y, width, height);
        g.setColor(Color.ORANGE);
        g.drawRect(x, y, width, height);
    }

    @Override
    public boolean contains(int mouseX, int mouseY) {
        int x2 = this.x + width;
        int y2 = this.y + height;

        return mouseX >= x && mouseX <= x2 && mouseY >= y && mouseY <= y2;
    }

}
