package com.accenture.challenge;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiSteps {
    private static final String BASE_URI = "https://demoqa.com";

    private String username;
    private String password;
    private String userId;
    private String token;
    private List<String> selectedIsbns;

    @Dado("que crio um usuário exclusivo")
    public void createUniqueUser() {
        String suffix = UUID.randomUUID().toString().replace("-", "");
        username = "qa_r2_" + suffix;
        password = "Qa!9" + suffix + "aA";

        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(credentials())
                .post("/Account/v1/User");

        assertEquals(201, response.statusCode(), "A criação do usuário não retornou HTTP 201");
        userId = response.jsonPath().getString("userID");
        assertNotNull(userId, "A criação do usuário não retornou userID");
        assertFalse(userId.isBlank(), "A criação do usuário retornou userID vazio");
        assertEquals(username, response.jsonPath().getString("username"),
                "O nome retornado não corresponde ao nome enviado");
    }

    @Quando("gero um token para o usuário")
    public void generateToken() {
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(credentials())
                .post("/Account/v1/GenerateToken");

        assertEquals(200, response.statusCode(), "A geração do token não retornou HTTP 200");
        assertEquals("Success", response.jsonPath().getString("status"),
                "A API não informou sucesso na geração do token");
        token = response.jsonPath().getString("token");
        assertNotNull(token, "A API não retornou token");
        assertFalse(token.isBlank(), "A API retornou token vazio");
    }

    @Entao("o usuário está autorizado")
    public void confirmAuthorization() {
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(credentials())
                .post("/Account/v1/Authorized");

        assertEquals(200, response.statusCode(), "A confirmação de autorização não retornou HTTP 200");
        assertTrue(response.as(Boolean.class), "A API informou que o usuário não está autorizado");
    }

    @Quando("consulto o catálogo de livros")
    public void listCatalog() {
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .get("/BookStore/v1/Books");

        assertEquals(200, response.statusCode(), "A consulta do catálogo não retornou HTTP 200");
        List<String> catalogIsbns = response.jsonPath().getList("books.isbn", String.class);
        assertNotNull(catalogIsbns, "A consulta do catálogo não retornou a coleção de ISBNs");

        selectedIsbns = catalogIsbns.stream()
                .filter(isbn -> isbn != null && !isbn.isBlank())
                .distinct()
                .limit(2)
                .toList();
        assertEquals(2, selectedIsbns.size(), "O catálogo não forneceu dois ISBNs distintos");
    }

    @Quando("associo dois livros distintos do catálogo ao usuário")
    public void associateSelectedBooks() {
        List<Map<String, String>> collection = selectedIsbns.stream()
                .map(isbn -> Map.of("isbn", isbn))
                .toList();

        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .auth().oauth2(token)
                .body(Map.of("userId", userId, "collectionOfIsbns", collection))
                .post("/BookStore/v1/Books");

        assertEquals(201, response.statusCode(), "A associação dos livros não retornou HTTP 201");
        assertSameBooks(selectedIsbns, response.jsonPath().getList("books.isbn", String.class),
                "A resposta da associação não contém exatamente os dois ISBNs escolhidos");
    }

    @Entao("a consulta do usuário apresenta os dois livros escolhidos")
    public void queryUserWithSelectedBooks() {
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .auth().oauth2(token)
                .pathParam("userId", userId)
                .get("/Account/v1/User/{userId}");

        assertEquals(200, response.statusCode(), "A consulta do usuário não retornou HTTP 200");
        assertEquals(userId, response.jsonPath().getString("userId"),
                "A consulta retornou outro identificador de usuário");
        assertEquals(username, response.jsonPath().getString("username"),
                "A consulta retornou outro nome de usuário");
        assertSameBooks(selectedIsbns, response.jsonPath().getList("books.isbn", String.class),
                "A consulta do usuário não contém exatamente os dois ISBNs escolhidos");
    }

    private Map<String, String> credentials() {
        return Map.of("userName", username, "password", password);
    }

    private static void assertSameBooks(List<String> expected, List<String> actual, String message) {
        assertNotNull(actual, message);
        Set<String> expectedSet = new LinkedHashSet<>(expected);
        Set<String> actualSet = new LinkedHashSet<>(actual);
        assertEquals(2, actual.size(), message);
        assertEquals(expectedSet, actualSet, message);
    }
}
