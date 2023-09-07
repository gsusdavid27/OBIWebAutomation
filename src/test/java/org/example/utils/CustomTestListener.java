package org.example.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // Se ejecuta cuando comienza un caso de prueba
        System.out.println("Iniciando el caso de prueba: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Se ejecuta cuando un caso de prueba tiene éxito
        System.out.println("Caso de prueba exitoso: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Se ejecuta cuando un caso de prueba falla
        System.out.println("Caso de prueba fallido: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Se ejecuta cuando se omite un caso de prueba
        System.out.println("Caso de prueba omitido: " + result.getName());
    }
}
