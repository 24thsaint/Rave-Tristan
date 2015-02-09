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

import com.midpaint.commands.ChangeColorCommand;
import com.midpaint.commands.DeleteShapeCommand;
import com.midpaint.commands.Invoker;
import com.midpaint.objects.Canvas;
import com.midpaint.objects.Shape;
import java.awt.Color;
import javax.swing.JColorChooser;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class PaintFrame extends javax.swing.JFrame {

    /**
     * Creates new form PaintFrame
     */
    public PaintFrame() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        canvasPanel1 = new com.midpaint.interfaces.CanvasPanel();
        drawEllipsButton = new javax.swing.JButton();
        drawSquareButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        fillShape = new java.awt.Button();
        undo = new javax.swing.JButton();
        redo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MidPaint");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        canvasPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout canvasPanel1Layout = new javax.swing.GroupLayout(canvasPanel1);
        canvasPanel1.setLayout(canvasPanel1Layout);
        canvasPanel1Layout.setHorizontalGroup(
            canvasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        canvasPanel1Layout.setVerticalGroup(
            canvasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvasPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvasPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1.setLayer(canvasPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        drawEllipsButton.setText("Draw Ellipse");
        drawEllipsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), null));
        drawEllipsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawEllipsButtonActionPerformed(evt);
            }
        });

        drawSquareButton.setText("Draw Square");
        drawSquareButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), null));
        drawSquareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawSquareButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), null));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        fillShape.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fillShape.setLabel("Fill Shape");
        fillShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillShapeActionPerformed(evt);
            }
        });

        undo.setText("Undo");
        undo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), null));
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        redo.setText("Redo");
        redo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51), null));
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(drawEllipsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(drawSquareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(redo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillShape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 242, Short.MAX_VALUE))
                    .addComponent(jDesktopPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(drawEllipsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(drawSquareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fillShape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(redo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(undo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void drawEllipsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawEllipsButtonActionPerformed
        canvasPanel1.addEllipse();
    }//GEN-LAST:event_drawEllipsButtonActionPerformed

    private void drawSquareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawSquareButtonActionPerformed
        canvasPanel1.addSquare();
    }//GEN-LAST:event_drawSquareButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        shape = canvasPanel1.getCanvas().getSelectedShape();
        canvas = canvasPanel1.getCanvas();

        if (canvasPanel1.getCanvas().getSelectedShape() != null) {
            DeleteShapeCommand deleteShape = new DeleteShapeCommand(shape, canvas);
            deleteShape.execute();
            canvasPanel1.getInvoker().addCommand(deleteShape);
            repaint();
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void fillShapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillShapeActionPerformed

        shape = canvasPanel1.getCanvas().getSelectedShape();
        canvas = canvasPanel1.getCanvas();
        Color oldColor = canvasPanel1.getCanvas().getSelectedShape().getColor();

        if (canvasPanel1.getCanvas().getSelectedShape() != null) {
            color = JColorChooser.showDialog(rootPane, "Color Chooser", Color.black);
//            canvasPanel1.getCanvas().getSelectedShape().setColor(color);
            ChangeColorCommand changeColor = new ChangeColorCommand(shape, canvas, oldColor);
            changeColor.setNewColor(color);
            changeColor.execute();
            canvasPanel1.getInvoker().addCommand(changeColor);
            repaint();
        }


    }//GEN-LAST:event_fillShapeActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        canvasPanel1.undo();
    }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        canvasPanel1.redo();
    }//GEN-LAST:event_redoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaintFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaintFrame().setVisible(true);
            }
        });
    }
    private Invoker invoker = new Invoker();
    private Shape shape;
    private Canvas canvas;
    private Color color;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.midpaint.interfaces.CanvasPanel canvasPanel1;
    private javax.swing.JButton drawEllipsButton;
    private javax.swing.JButton drawSquareButton;
    private java.awt.Button fillShape;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JButton redo;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables
}
