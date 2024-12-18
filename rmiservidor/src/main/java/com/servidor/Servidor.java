package com.servidor;

import com.rmi.Calculadora;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Crear instancia de la implementación
            Calculadora calc = new CalculadoraImpl();

            // Crear el registro RMI en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Publicar el objeto remoto con el nombre "CalculadoraService"
            registry.rebind("CalculadoraService", calc);

            System.out.println("Servidor listo y esperando peticiones...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
