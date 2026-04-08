package org.example;

public class QuitException extends RuntimeException {
    public QuitException() {
        super("Quit requested");
    }
}