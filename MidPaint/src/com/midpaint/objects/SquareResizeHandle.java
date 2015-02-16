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


/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class SquareResizeHandle extends Rectangle {

    private int cursorType;

    public SquareResizeHandle(int x, int y, int cursorType) {
        super(x, y);
        this.cursorType = cursorType;
    }

    public int getCursorType() {
        return cursorType;
    }

    public void setCursorType(int cursorType) {
        this.cursorType = cursorType;
    }

}
