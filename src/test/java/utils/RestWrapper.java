package utils;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import pojos.UserLogin;
import utils.services.OrderService;
import utils.services.UserService;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    private static final String BASE_URL = "https://reqres.in/";
    private Cookies cookies;

    public UserService user;
    public OrderService order;


    private RestWrapper(Cookies cookies){
        this.cookies = cookies;

        user = new UserService(cookies);
        order= new OrderService(cookies);
//
//        REQ_SPEC = new RequestSpecBuilder()
//                .addCookies(cookies)
//                .setBaseUri(BASE_URL)
//                .setBasePath("api/users")
//                .setContentType(ContentType.JSON)
//                .build();
    }

    public static RestWrapper loginAs(String login, String password){
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("api/login")
                .body(new UserLogin(login,password))
                .post()
                .getDetailedCookies();

        return new RestWrapper(cookies);
    }

//    public CreateUserResponse createUser(CreateUserRequest request){
//        return  given()
//                .spec(REQ_SPEC)
//                .body(request)
//                .post()
//                .as(CreateUserResponse.class);
//
//    }
//
//    public List<UserPojoFull> getUsers(){
//        return given()
//                .spec(REQ_SPEC)
//                .get()
//                .jsonPath().getList("data", UserPojoFull.class);
//    }

}
