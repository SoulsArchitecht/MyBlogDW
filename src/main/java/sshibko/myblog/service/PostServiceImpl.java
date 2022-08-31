package sshibko.myblog.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.PostListResponse;
import sshibko.myblog.api.response.PostResponse;
import sshibko.myblog.model.dto.mapper.CalculatedPostDto;
import sshibko.myblog.model.dto.mapper.PostMapperDto;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.model.enums.ModerationStatus;
import sshibko.myblog.repository.PostRepository;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class PostServiceImpl implements PostService {
/*    public List<PostResponse> postResponseList;

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
    }*/

    private Sort sort;
    private final int MAX_LENGTH = 150;
    private final int MIN_TITLE_LENGTH = 3;
    private final int MIN_TEXT_LENGTH = 10;
    public static final int moderatorId = 5;

    private final PostRepository postRepository;
/*    @Autowired
    private final UserService userService;*/

    private final PostMapperDto postMapperDto;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapperDto postMapperDto) {
        this.postRepository = postRepository;
        this.postMapperDto = postMapperDto;
    }

    public PostResponse getPosts(int offset, int limit, String mode) {

        PostResponse postResponse = new PostResponse();

        if (mode.equals("recent")) {
            sort = Sort.by("time").descending();
            Page<Post> recentPage = postRepository.findAll(getSortedPaging(offset, limit, sort));
            postResponse.setCount(recentPage.getTotalElements());
            postResponse.setPosts(toPostDto(recentPage));
        }
        if (mode.equals("best")) {
            Page<Posts> popularPage = postRepository.findPostsOrderByLikes(getPaging(offset, limit));
            postResponse.setCount(popularPage.getTotalElements());
            postResponse.setPosts(toPostDto(popularPage));
        }
        if (mode.equals("popular")) {
            Page<Posts> bestPage = postRepository.findPostsOrderByComments(getPaging(offset, limit));
            postResponse.setCount(bestPage.getTotalElements());
            postResponse.setPosts(toPostDto(bestPage));
        }
        if (mode.equals("early")) {
            sort = Sort.by("time").ascending();
            Page<Posts> earlyPage = postRepository.findAll(getSortedPaging(offset, limit, sort));
            postResponse.setCount(earlyPage.getTotalElements());
            postResponse.setPosts(toPostDto(earlyPage));
        }
        return postResponse;
    }

    @Override
    public Optional<Post> getPost(int id) {
        return postRepository.findPostById(id);
    }

    @Override
    public PostListResponse getPostList(int offset, int limit, String mode) {
        int count = postRepository.getPostCount(true, ModerationStatus.ACCEPTED,
                LocalDateTime.now(Clock.system(ZoneId.systemDefault())));
        List<CalculatedPostDto> calculatedPostDtoList = postRepository.getCalculatedPostDtoList(
                true, ModerationStatus.ACCEPTED, LocalDateTime.now(Clock.system(ZoneId.systemDefault())),
                getPageRequest(offset, limit, mode)
        );

        List<PostResponse> postResponseList = calculatedPostDtoList.stream()
                .map(postMapperDto::calculatedPostDtoToPostDto)
                .collect(Collectors.toList());

        return new PostListResponse(count, postResponseList);
    }

    private PageRequest getPageRequest(int offset, int limit, String mode) {
        Sort sortByViewCountDesc = Sort.by(Sort.Direction.DESC, "viewCount");
        Sort sortByTimeDesc = Sort.by(Sort.Direction.DESC, "time");
        Sort sort;
        switch (mode) {
            case "popular":
                sort = JpaSort.unsafe(Sort.Direction.DESC, "size(p.postComments)")
                        .and(sortByViewCountDesc)
                        .and(sortByTimeDesc);
                break;
            case "early":
                sort = Sort.by("time");
                break;
            case "best":
                sort = JpaSort.unsafe(Sort.Direction.DESC, "size(p.postVotes)")
                        .and(sortByViewCountDesc)
                        .and(sortByTimeDesc);
                break;
            case "recent":
                sort = sortByTimeDesc;
                break;
            //default include the "recent" by the tech task
            default:
                sort = sortByTimeDesc;
                break;
        }

        int pageNum = offset / limit;
        return PageRequest.of(pageNum, limit, sort);
    }
}
