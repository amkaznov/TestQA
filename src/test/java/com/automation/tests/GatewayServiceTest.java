package com.automation.tests;

import com.automation.base.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Тесты для проверки сервисов через API Gateway
 */
@DisplayName("Gateway Service Tests")
public class GatewayServiceTest extends BaseTest {

    @Test
    @DisplayName("Check Service1 through Gateway")
    public void checkServiceThroughGateway() {
        given()
                .spec(requestSpec)
        .when()
                .get("/service1/api/hello")
        .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    @DisplayName("Check Wiremock through Gateway")
    public void checkWiremockThroughGateway() {
        given()
                .spec(requestSpec)
        .when()
                .get("/mock/external/data")
        .then()
                .statusCode(200)
                .body(notNullValue());
    }
}
