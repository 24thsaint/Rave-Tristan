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

import com.midpaint.commands.DeleteShapeCommand;
import com.midpaint.commands.DrawShapeCommand;
import com.midpaint.commands.Invoker;
import com.midpaint.commands.MoveShapeCommand;
import com.midpaint.objects.Canvas;
import com.midpaint.objects.Ellipse;
import com.midpaint.objects.Shape;
import com.midpaint.objects.Square;
import com.midpaint.objects.SquareResizeHandle;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
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
    private MoveShapeCommand moveShapeCommand;
    private Invoker invoker = new Invoker();

    public Canvas getCanvas() {
        return canvas;
    }

    public Invoker getInvoker() {
        return invoker;
    }

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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
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
        if (canvas.getSelectedShape() == null) {
            return;
        }

        Shape shape = canvas.getSelectedShape();

        if (canMove) {
            int x = evt.getX() - deltaX;
            int y = evt.getY() - deltaY;
            shape.alterShape(x, y, shape.getWidth(), shape.getHeight());
            setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }

        if (canResize) {
            int width = evt.getX() - shape.getX();
            int height = evt.getY() - shape.getY();
//            shape.resize(width, height);

            for (SquareResizeHandle resizeHandle : resizeHandles) {
                if (resizeHandle.contains(evt.getX(), evt.getY())) {
                    switch (resizeHandle.getCursorType()) {
                        case Cursor.N_RESIZE_CURSOR:
                            int heightC = shape.getHeight() - height;
                            shape.alterShape(shape.getX(), shape.getY() + height, shape.getWidth(), heightC);                            
                            break;
                        case Cursor.NW_RESIZE_CURSOR:
                            int widthC = shape.getWidth() - width;
                            heightC = shape.getHeight() - height;
                            shape.alterShape(shape.getX() + width, shape.getY() + height, widthC, heightC);
                            break;
                        case Cursor.W_RESIZE_CURSOR:
                            widthC = shape.getWidth() - width;
                            shape.alterShape(shape.getX() + widthC, shape.getY(), widthC, shape.getHeight());
                            break;
                        case Cursor.SW_RESIZE_CURSOR:
                            widthC = shape.getWidth() - width;
                            heightC = height;
                            shape.alterShape(shape.getX() + width, shape.getY(), widthC, heightC);
                            break;
                        case Cursor.S_RESIZE_CURSOR:
                            heightC = height;
                            shape.alterShape(shape.getX(), shape.getY(), shape.getWidth(), heightC);
                            break;
                        case Cursor.SE_RESIZE_CURSOR:
                            widthC = width;
                            heightC = height;
                            shape.alterShape(shape.getX(), shape.getY(), widthC, heightC);
                            break;
                        case Cursor.E_RESIZE_CURSOR:
                            widthC = width;
                            shape.alterShape(shape.getX(), shape.getY(), widthC, shape.getHeight());
                            break;
                        case Cursor.NE_RESIZE_CURSOR:
                            widthC = width;
                            heightC = shape.getHeight() - height;
                            shape.alterShape(shape.getX(), shape.getY() + height, widthC, heightC);
                            break;
                    }
                    break;
                }
            }
        }

        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

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
                    moveShapeCommand = new MoveShapeCommand(shape, canvas, shape.getX(), shape.getY());
                }
            }

            System.out.println(canResize);
            System.out.println(canMove);
        }
        requestFocus();
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if (moveShapeCommand != null) {
            moveShapeCommand.setNewLocation(
                    canvas.getSelectedShape().getX(),
                    canvas.getSelectedShape().getY());
            invoker.addCommand(moveShapeCommand);
            moveShapeCommand = null;
        }
    }//GEN-LAST:event_formMouseReleased

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

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (canvas.getSelectedShape() != null && evt.getKeyCode() == KeyEvent.VK_DELETE) {
            DeleteShapeCommand deleteCommand = new DeleteShapeCommand(canvas.getSelectedShape(), canvas);
            deleteCommand.execute();
            canvas.setSelectedShape(null);
            repaint();
            invoker.addCommand(deleteCommand);
//            canvas.removeShape(canvas.getSelectedShape());
        }
    }//GEN-LAST:event_formKeyPressed

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

        DrawShapeCommand drawShapeCommand = new DrawShapeCommand(ellipse, canvas);
        drawShapeCommand.execute();
        invoker.addCommand(drawShapeCommand);

        System.out.println(ellipse + " added to canvas");
        repaint();
    }

    public void addSquare() {
        Square square = new Square(random.nextInt(getWidth() - Shape.PRIMARY_SIZE),
                random.nextInt(getHeight() - Shape.PRIMARY_SIZE),
                Shape.PRIMARY_SIZE,
                Shape.PRIMARY_SIZE);

        DrawShapeCommand drawShapeCommand = new DrawShapeCommand(square, canvas);
        drawShapeCommand.execute();
        invoker.addCommand(drawShapeCommand);

        System.out.println(square + " added to canvas");
        repaint();
    }

    public void undo() {        
        invoker.undo().unexecute();
        repaint();
    }

    public void redo() {
        invoker.redo().execute();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
