package utils.services;

import io.restassured.http.Cookies;
import pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OrderService extends RestService{

    public OrderService(Cookies cookies) {
        super(cookies);
    }

    @Override
    protected String getBasePath(){
        return "api/orders";
    }

    public List<UserPojoFull> getUsers(){
        return given()
                .spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }
}
