package sshibko.myblog.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.UserForPostResponse;
import sshibko.myblog.model.entity.User;

import java.time.LocalDateTime;

@Data
@Service
public class UserServiceImpl implements UserService {

    //temporary stopper before DB injection
    @Override
    public User getUser(int id) {
        return new User(1, false, LocalDateTime.parse("22/12/1959"), "John", "post", "password", "code", "photo" );
    }

    @Override
    public Boolean getApiAuthCheck() {
        return true;
    }

    @Override
    public UserForPostResponse getUserForPostResponse(User user) {
        UserForPostResponse userForPostResponse = new UserForPostResponse();
        userForPostResponse.setId(user.getId());
        userForPostResponse.setName(user.getName());
        return userForPostResponse;
    }

}
