package org.example.lesson3;

import java.util.Scanner;

public class Triangle {

    void triangleArea (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую сторону треугольника: ");
        int a = scanner.nextInt();

        System.out.println("Введите вторую сторону треугольника: ");
        int b = scanner.nextInt();

        System.out.println("Введите третью сторону треугольника: ");
        int c = scanner.nextInt();
        double p = (a + b + c) / 2;
        double area = (p * (p - a) * (p - b) * (p - c)) * 0.5;
        System.out.println("Площадь треугольника равна: " + area);
    }

    public int someMethod(int a, int b, int c)  {
        if (a < 0 || b < 0 || c < 0) try {
            throw new MyException("Отрицательное число");
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
}
