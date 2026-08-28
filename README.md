# Lab3_Bancario_HannerContreras
# Laboratorio #3 - Migración Bancaria C++ a Java

**Universidad de los Llanos**  
**Facultad de Ciencias Básicas e Ingeniería**  
**Programa: Ingeniería de Sistemas**  

**Estudiante:** Hanner Contreras  
**Código:** 160005312  
**Docente:** OLGA LUCERO VEGA MARQUEZ  
**Fecha:** 24 de agosto de 2026  

---

## Descripción del Proyecto

Migración de un sistema bancario legacy escrito en C++ a una arquitectura orientada a objetos en Java 21, aplicando:

- Auditoría de memoria y fugas en C++.
- Herencia, clases abstractas y polimorfismo en Java.
- Gestión de recursos con `AutoCloseable` y `try-with-resources`.
- Interacción socrática con IA (Gemini).

---

## Estructura del Repositorio
/Lab3_Bancario_HannerContreras/
```
/Lab3_Bancario_HannerContreras/
├── README.md
├── cpp/
│   └── SistemaBancarioLegacy.cpp
├── java/
│   └── src/
│       └── bancario/
│           ├── CuentaBancaria.java
│           ├── CuentaAhorros.java
│           ├── CuentaCorriente.java
│           ├── SaldoInsuficienteException.java
│           ├── RegistroAuditoriaBancaria.java
│           └── Main.java
├── docs/
│   └── Informe_Lab3_HannerContreras.pdf
└── auditoria.log  (generado al ejecutar)
```


---

## Cómo Compilar y Ejecutar

### Compilar:
```bash
javac java/src/bancario/*.java

java -cp java/src bancario.Main
