package org.example;

public class ComplexNumber {

    private double real, imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        this.real = this.getReal() + real;
        this.imaginary = this.getImaginary() + imaginary;
    }

    public void add(ComplexNumber complex) {
        this.real = this.getReal() + complex.getReal();
        this.imaginary = this.getImaginary() + complex.getImaginary();
    }

    public void subtract(double real, double imaginary) {
        this.real = this.getReal() - real;
        this.imaginary = this.getImaginary() - imaginary;
    }

    public void subtract(ComplexNumber complex) {
        this.real = this.getReal() - complex.getReal();
        this.imaginary = this.getImaginary() - complex.getImaginary();
    }
}
