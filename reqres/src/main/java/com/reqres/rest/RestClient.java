package com.reqres.rest;

import com.reqres.models.post.BasicUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.reqres.constants.Endpoints.*;
import static io.restassured.RestAssured.given;

public class RestClient {

    public static Response getUser(int id) {
        return RestAssured.given()
                .when()
                .get(URL + SINGE_USER + id)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response getUser(String id) {
        return RestAssured.given()
                .when()
                .get(URL + SINGE_USER + id)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response getUserList() {
        return RestAssured.given()
                .when()
                .get(URL + LIST_USER)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response getResourcesList() {
        return RestAssured.given()
                .when()
                .get(URL + LIST_RESOURCES)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response getResources(int id) {
        return RestAssured.given()
                .when()
                .get(URL + SINGE_RESOURCES + id)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response createUser(BasicUser user) {
        return RestAssured.given()
                .body(user)
                .when()
                .post(URL + POST_USER)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response updateUser(int id, BasicUser user) {
        return RestAssured.given()
                .when()
                .put(URL + SINGE_USER + id)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response patchUser(int id, BasicUser user) {
        return RestAssured.given()
                .when()
                .patch(URL + SINGE_USER + id)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response deleteUser(int id) {
        return RestAssured.given()
                .when()
                .delete(URL + SINGE_USER + id)
                .then()
                .log().all()
                .extract().response();
    }
}
