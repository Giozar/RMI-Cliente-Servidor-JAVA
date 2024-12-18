# README: Proyectos RMI (Calculadora, RMIServidor, RMICliente)

## **Descripción del Proyecto**
Este proyecto implementa un sistema RMI (Remote Method Invocation) en Java, compuesto por tres proyectos independientes:

1. **Calculadora**: Define la interfaz remota que contiene los métodos a ser utilizados por el cliente y el servidor.
2. **RMIServidor**: Implementa la interfaz `Calculadora` y publica el servicio remoto.
3. **RMICliente**: Consume el servicio remoto publicado por el servidor.

A continuación, se describen los pasos para compilar, empaquetar y ejecutar cada uno de los proyectos en **Windows** y **Linux**.

---

## **Requisitos Previos**
- Java Development Kit (JDK) 8 o superior instalado.
- Configurado el entorno de `JAVA_HOME` y `PATH` para que `java`, `javac` y `jar` estén disponibles desde la terminal.
- Editor de texto o IDE (opcional, pero recomendado: VSCode, IntelliJ, NetBeans).

---

## **1. Proyecto Calculadora**

### **Estructura del Proyecto**
```
calculadora/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── rmi/
│                   └── Calculadora.java
```

### **Pasos para Compilar y Empaquetar**

#### **Linux**
```bash
cd calculadora
# Compilar la interfaz
javac -d target/classes src/main/java/com/rmi/Calculadora.java
# Crear el JAR
jar cvf calculadora.jar -C target/classes .
```

#### **Windows**
```powershell
cd calculadora
# Compilar la interfaz
javac -d target/classes src\main\java\com\rmi\Calculadora.java
# Crear el JAR
jar cvf calculadora.jar -C target/classes .
```

### **Resultado**
Se genera el archivo `calculadora.jar` en la raíz del proyecto. Este archivo debe ser copiado en los proyectos `rmiservidor` y `rmicliente` dentro de una carpeta `lib`.

---

## **2. Proyecto RMIServidor**

### **Estructura del Proyecto**
```
rmiservidor/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── servidor/
│                   ├── CalculadoraImpl.java
│                   └── Servidor.java
├── lib/
    └── calculadora.jar
```

### **Pasos para Compilar y Empaquetar**

#### **Linux**
```bash
cd rmiservidor
# Compilar el servidor
javac -cp lib/calculadora.jar -d target/classes src/main/java/com/servidor/*.java
# Crear el JAR
jar cvf rmiservidor.jar -C target/classes .
```

#### **Windows**
```powershell
cd rmiservidor
# Compilar el servidor
javac -cp lib\calculadora.jar -d target/classes src\main\java\com\servidor\*.java
# Crear el JAR
jar cvf rmiservidor.jar -C target/classes .
```

### **Ejecución del Servidor**

#### **Linux**
```bash
java -cp rmiservidor.jar:lib/calculadora.jar com.servidor.Servidor
```

#### **Windows**
```powershell
java -cp rmiservidor.jar;lib\calculadora.jar com.servidor.Servidor
```

### **Resultado Esperado**
El servidor debe mostrar:
```
Servidor listo y esperando peticiones...
```

---

## **3. Proyecto RMICliente**

### **Estructura del Proyecto**
```
rmicliente/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── cliente/
│                   └── Cliente.java
├── lib/
    └── calculadora.jar
```

### **Pasos para Compilar y Empaquetar**

#### **Linux**
```bash
cd rmicliente
# Compilar el cliente
javac -cp lib/calculadora.jar -d target/classes src/main/java/com/cliente/Cliente.java
# Crear el JAR
jar cvf rmicliente.jar -C target/classes .
```

#### **Windows**
```powershell
cd rmicliente
# Compilar el cliente
javac -cp lib\calculadora.jar -d target/classes src\main\java\com\cliente\Cliente.java
# Crear el JAR
jar cvf rmicliente.jar -C target/classes .
```

### **Ejecución del Cliente**

#### **Linux**
```bash
java -cp rmicliente.jar:lib/calculadora.jar com.cliente.Cliente
```

#### **Windows**
```powershell
java -cp rmicliente.jar;lib\calculadora.jar com.cliente.Cliente
```

### **Resultado Esperado**
El cliente debe mostrar:
```
Suma (5 + 3): 8
Resta (10 - 4): 6
```

---

## **Resumen de Comandos**

### **Compilación y Empaquetado**
- **Calculadora**:
  - `javac -d target/classes src/main/java/com/rmi/Calculadora.java`
  - `jar cvf calculadora.jar -C target/classes .`

- **RMIServidor**:
  - `javac -cp lib/calculadora.jar -d target/classes src/main/java/com/servidor/*.java`
  - `jar cvf rmiservidor.jar -C target/classes .`

- **RMICliente**:
  - `javac -cp lib/calculadora.jar -d target/classes src/main/java/com/cliente/Cliente.java`
  - `jar cvf rmicliente.jar -C target/classes .`

### **Ejecución**
- **Servidor**:
  - Linux: `java -cp rmiservidor.jar:lib/calculadora.jar com.servidor.Servidor`
  - Windows: `java -cp rmiservidor.jar;lib\calculadora.jar com.servidor.Servidor`

- **Cliente**:
  - Linux: `java -cp rmicliente.jar:lib/calculadora.jar com.cliente.Cliente`
  - Windows: `java -cp rmicliente.jar;lib\calculadora.jar com.cliente.Cliente`

---

## **Cómo Cambiar la Versión de Java**
Si necesitas cambiar entre diferentes versiones de Java instaladas, sigue estos pasos:

### **Linux**
1. Verifica las versiones disponibles:
   ```bash
   update-alternatives --config java
   update-alternatives --config javac
   ```
2. Selecciona la versión deseada de la lista que aparece.

### **Windows**
1. Abre el Panel de Control y busca "Variables de Entorno".
2. Edita la variable `JAVA_HOME` para apuntar a la ruta de la versión deseada, por ejemplo:
   ```
   C:\Program Files\Java\jdk-17
   ```
3. Asegúrate de que la carpeta `bin` de la versión seleccionada esté en el `Path`, por ejemplo:
   ```
   C:\Program Files\Java\jdk-17\bin
   ```
4. Reinicia la terminal para aplicar los cambios.

---

## **Notas Adicionales**
- Asegúrate de que el servidor esté ejecutándose antes de iniciar el cliente.
- Verifica que todas las rutas sean correctas y que `calculadora.jar` esté en la carpeta `lib` de los proyectos `rmiservidor` y `rmicliente`.
- Si encuentras problemas con versiones de Java, utiliza el flag `--release` al compilar para asegurar compatibilidad, por ejemplo:
  ```bash
  javac --release 8 -cp lib/calculadora.jar -d target/classes src/main/java/com/servidor/*.java
  ```


