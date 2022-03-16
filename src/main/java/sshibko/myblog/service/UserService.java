package sshibko.myblog.service;

import sshibko.myblog.api.response.UserForPostResponse;
import sshibko.myblog.model.entity.User;

public interface UserService {

    User getUser(int id);

    Boolean getApiAuthCheck();

    UserForPostResponse getUserForPostResponse(User user);
}
