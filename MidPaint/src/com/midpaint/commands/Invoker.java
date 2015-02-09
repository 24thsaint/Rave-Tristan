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

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class Invoker {

    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public Command undo() {
        Command command = null;
        try {
            command = undoStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Nothing to undo");
            command = new NullCommand();
        }
        redoStack.push(command);
        return command;
    }

    public Command redo() {
        Command command = null;
        try{
            command = redoStack.pop();
        }
        catch (EmptyStackException e){
            System.out.println("Nothing to redo");
            command = new NullCommand();
        }
        undoStack.push(command);
        return command;
    }

    public void addCommand(Command command) {
        undoStack.add(command);
        redoStack.clear();
    }

}
