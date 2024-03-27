package utils.services;

import io.restassured.http.Cookies;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestService{


    public UserService(Cookies cookies) {
        super(cookies);
    }

    @Override
    protected String getBasePath() {
        return "api/users";
    }

    public CreateUserResponse createUser(UserRequest request){
        return  given()
                .spec(REQ_SPEC)
                .body(request)
                .post()
                .as(CreateUserResponse.class);

    }

    public List<UserPojoFull> getUsers(){
        return given()
                .spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }
}
