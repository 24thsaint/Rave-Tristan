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
package com.midpaint.interfaces;

import com.midpaint.objects.Canvas;
import com.midpaint.objects.Ellipse;
import com.midpaint.objects.Shape;
import com.midpaint.objects.Square;
import com.midpaint.objects.SquareResizeHandle;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class CanvasPanel extends javax.swing.JPanel {

    private Canvas canvas = new Canvas();
    private Random random = new Random();
    private List<SquareResizeHandle> resizeHandles = new ArrayList<>();
    private boolean canResize = false;
    private boolean canMove = false;
    private int deltaX;
    private int deltaY;

    /**
     * Creates new form CanvasPanel
     */
    public CanvasPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        canvas.setSelectedShape(null);

        for (Shape shape : canvas.getShapes()) {
            if (shape.contains(evt.getX(), evt.getY())) {
                canvas.setSelectedShape(shape);
                System.out.println(shape + " has been selected.");
            } else {
                System.out.println("No shape selected");
            }
        }

        repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        for (SquareResizeHandle handle : resizeHandles) {
            if (handle.contains(evt.getX(), evt.getY())) {
                setCursor(Cursor.getPredefinedCursor(handle.getCursorType()));
                break;
            } else {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }//GEN-LAST:event_formMouseMoved

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged

        Shape shape = canvas.getSelectedShape();

        if (canMove) {
            int x = evt.getX() - deltaX;
            int y = evt.getY() - deltaY;
            shape.move(x, y);
            setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }

        if (canResize) {
            int width = evt.getX() - shape.getX();
            int height = evt.getY() - shape.getY();
            shape.resize(width, height);
        }
        
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        canResize = false;
        canMove = false;

        if (canvas.getSelectedShape() != null) {

            Shape shape = canvas.getSelectedShape();

            for (SquareResizeHandle resizeHandle : resizeHandles) {
                if (resizeHandle.contains(evt.getX(), evt.getY())) {
                    canResize = true; 
                    canMove = false;
                    break;
                } else {
                    canMove = true;
                    canResize = false;
                    deltaX = evt.getX() - shape.getX();
                    deltaY = evt.getY() - shape.getY();
                }
            }
            
            System.out.println(canResize);
            System.out.println(canMove);
        }
                
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseReleased

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape1 : canvas.getShapes()) {
            shape1.draw(g);
        }

        if (canvas.getSelectedShape() != null) {
            resizeHandles.clear();
            final int SQUARE_SIZE = 8;
            final int HALF_SQUARE_SIZE = SQUARE_SIZE / 2;

            int x = canvas.getSelectedShape().getX();
            int y = canvas.getSelectedShape().getY();
            int width = canvas.getSelectedShape().getWidth();
            int height = canvas.getSelectedShape().getHeight();

            resizeHandles.add(
                    new SquareResizeHandle(x - HALF_SQUARE_SIZE, y - HALF_SQUARE_SIZE, Cursor.NW_RESIZE_CURSOR)); // NW
            resizeHandles.add(
                    new SquareResizeHandle(x + (width / 2) - HALF_SQUARE_SIZE, y - HALF_SQUARE_SIZE, Cursor.N_RESIZE_CURSOR)); // N
            resizeHandles.add(
                    new SquareResizeHandle(x + width - HALF_SQUARE_SIZE, y - HALF_SQUARE_SIZE, Cursor.NE_RESIZE_CURSOR)); // NE

            resizeHandles.add(
                    new SquareResizeHandle(x - HALF_SQUARE_SIZE, y + (height / 2) - HALF_SQUARE_SIZE, Cursor.E_RESIZE_CURSOR)); // E
            resizeHandles.add(
                    new SquareResizeHandle(x + width - HALF_SQUARE_SIZE, y + (height / 2) - HALF_SQUARE_SIZE, Cursor.W_RESIZE_CURSOR)); // W

            resizeHandles.add(
                    new SquareResizeHandle(x - HALF_SQUARE_SIZE, y + height - HALF_SQUARE_SIZE, Cursor.SW_RESIZE_CURSOR)); // SW
            resizeHandles.add(
                    new SquareResizeHandle(x + (width / 2) - HALF_SQUARE_SIZE, y + (height) - HALF_SQUARE_SIZE, Cursor.S_RESIZE_CURSOR)); // S
            resizeHandles.add(
                    new SquareResizeHandle(x + width - HALF_SQUARE_SIZE, y + height - HALF_SQUARE_SIZE, Cursor.SE_RESIZE_CURSOR)); // SE

            g.setColor(Color.BLACK);

            for (Square handle : resizeHandles) {
                g.fillRect(handle.getX(), handle.getY(), SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    public void addEllipse() {
        Ellipse ellipse = new Ellipse(random.nextInt(getWidth() - Shape.PRIMARY_SIZE),
                random.nextInt(getHeight() - Shape.PRIMARY_SIZE),
                Shape.PRIMARY_SIZE,
                Shape.PRIMARY_SIZE
        );

        canvas.addShape(ellipse);
        System.out.println(ellipse + " added to canvas");
        repaint();
    }

    public void addSquare() {
        Square square = new Square(random.nextInt(getWidth() - Shape.PRIMARY_SIZE),
                random.nextInt(getHeight() - Shape.PRIMARY_SIZE),
                Shape.PRIMARY_SIZE,
                Shape.PRIMARY_SIZE);
        canvas.addShape(square);
        System.out.println(square + " added to canvas");
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
