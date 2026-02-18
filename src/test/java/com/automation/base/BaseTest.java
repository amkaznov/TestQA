package com.automation.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

/**
 * Базовый класс для REST API тестов
 */
public class BaseTest {

    protected static RequestSpecification requestSpec;
    protected static String gatewayUrl;

    @BeforeAll
    public static void setupRequestSpec() {
        // Получаем базовый URL из системной переменной
        gatewayUrl = System.getProperty("gateway.url", "localhost:8080");
        
        // Формируем полный базовый URL
        String baseUri = "http://" + gatewayUrl;
        
        // Создаем RequestSpecification для всех тестов
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType("application/json")
                .build();
        
        RestAssured.requestSpecification = requestSpec;
    }
}
