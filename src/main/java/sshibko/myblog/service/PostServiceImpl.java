package sshibko.myblog.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.PostResponse;
import sshibko.myblog.api.response.UserForPostResponse;

import java.util.List;

@Data
@Service
public class PostService {
    public List<PostResponse> postResponseList;

    //temporary stopper before DB injection

    public PostResponse getPost() {
        PostResponse postResponse = new PostResponse();
        postResponse.setId(1);
        postResponse.setUserForPostResponse(new UserForPostResponse(1, "Vanya Zhukov"));
        postResponse.setTitle("New Posts Title");
        postResponse.setAnnounce("The long long text");
        postResponse.setViewCount(1000);
        postResponse.setCommentCount(22);

        return postResponse;
    }

    public List<PostResponse> getPostList() {
        return postResponseList;
    }

}
