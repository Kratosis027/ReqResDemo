package com.reqres.factory;

import com.reqres.models.post.BasicUser;
import com.reqres.models.response.User;

public class UserFactory {

    public static BasicUser getBasicUser() {
        String[] names = {"John", "Bob", "Steve", "Naruto"};
        String[] jobs = {"Accounter", "Engineer", "Hokage", "Hollow"};
        return BasicUser.builder()
                .name(names[(int) (Math.random() * names.length)])
                .job(jobs[(int) (Math.random() * jobs.length)])
                .build();
    }
}
