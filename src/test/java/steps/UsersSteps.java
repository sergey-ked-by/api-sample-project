//package steps;
//
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//import pojos.CreateUserRequest;
//import pojos.CreateUserResponse;
//import pojos.UserPojoFull;
//
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//
//public class UsersSteps {
//
//    public static final RequestSpecification REQ_SPEC =
//            new RequestSpecBuilder()
//                    .setBaseUri("https://reqres.in/")
//                    .setBasePath("api/users")
//                    .setContentType(ContentType.JSON)
//                    .build();
//
//    public static CreateUserResponse createUser(CreateUserRequest request){
//            return  given()
//                    .spec(REQ_SPEC)
//                    .body(request)
//                    .post()
//                    .as(CreateUserResponse.class);
//
//    }
//
//    public static UserPojoFull getUser(int id){
//        return given().get("/" + id).as(UserPojoFull.class);
//    }
//
//    public static List<UserPojoFull> getUsers(){
//        return given()
//                .spec(REQ_SPEC)
//                .get()
//                .jsonPath().getList("data", UserPojoFull.class);
//    }
//}
