package org.umsa;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ProfesionalesTest {
    @Test
    void testObtenerEspecialistasEndPoint() {
        given()
          .when().get("/especialistas")
          .then()
             .statusCode(200);
    }



}