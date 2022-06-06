package sshibko.myblog.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.UserForPostResponse;
import sshibko.myblog.model.entity.User;
import sshibko.myblog.repository.UserRepository;


@Data
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return userRepository.getById(id);
    }

    @Override
    public Boolean getApiAuthCheck() {
        return false;
    }

    @Override
    public UserForPostResponse getUserForPostResponse(User user) {
        UserForPostResponse userForPostResponse = new UserForPostResponse();
        userForPostResponse.setId(user.getId());
        userForPostResponse.setName(user.getName());
        return userForPostResponse;
    }

}
