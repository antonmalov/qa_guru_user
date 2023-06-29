package tests;

import models.UserData;
import org.junit.jupiter.api.Test;
import specs.Specs;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void getSingleUser() {
        Specs.request
                .when()
                .get("/users/2")
                .then()
                .spec(Specs.response)
                .log().body();
    }

    @Test
    void listOfUsers() {
        Specs.request
                .when()
                .get("/users?page=2")
                .then()
                .log().body();
    }

    @Test
    void getSingleUserWithModel() {
        UserData data = Specs.request
                .when()
                .get("/users/2")
                .then()
                .spec(Specs.response)
                .log().body()
                .extract().as(UserData.class);

        assertEquals(2, data.getData().getId());
    }
}
