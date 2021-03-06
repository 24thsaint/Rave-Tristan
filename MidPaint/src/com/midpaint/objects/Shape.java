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
import java.util.Random;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public abstract class Shape {

    public static final int PRIMARY_SIZE = 50;
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected Color color;

    protected Random random = new Random();

    public Shape(int x, int y, int height, int width) {
        alterShape(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public abstract boolean contains(int x, int y);

    public void alterShape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    public void ghostify(boolean doGhost) {
        int alpha = 0;
        int ghostAlpha = 100;
        int normalAlpha = 255;

        if (doGhost) {
            alpha = ghostAlpha;
        } else {
            alpha = normalAlpha;
        }

        Color color = new Color(getColor().getRed(),
                getColor().getGreen(), getColor().getBlue(), alpha);
        setColor(color);        
    }
}
