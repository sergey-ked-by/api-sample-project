package utils;

import pojos.UserRequest;

public class UserGenerator {

    public static UserRequest createNewUser(String name, String job){
        return UserRequest.builder()
                .name(name)
                .job(job)
                .build();
    }
}
