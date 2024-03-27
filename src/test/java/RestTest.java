import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {

    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient(){
        api = RestWrapper.loginAs("eve.holt@Reqres.in", "cityslicks");
    }

    @Test
    public void getUsers(){
        assertThat(api.user.getUsers())
                .isNotNull()
                .extracting(UserPojoFull::getEmail)
                .contains("george.bluth@reqres.in");
    }

    @Test
    public void createUser(){
        UserRequest request = UserGenerator.createNewUser("Sergey", "AQA");

        assertThat(api.user.createUser(request))
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(request.getName());
    }
}
