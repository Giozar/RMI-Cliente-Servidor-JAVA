package com.cliente;

import com.rmi.Calculadora;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        
            Calculadora calc = (Calculadora) registry.lookup("CalculadoraService");

            int suma = calc.sumar(5, 3);
            int resta = calc.restar(10, 4);

            System.out.println("Suma (5 + 3): " + suma);
            System.out.println("Resta (10 - 4): " + resta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
