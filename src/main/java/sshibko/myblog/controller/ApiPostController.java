package sshibko.myblog.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshibko.myblog.api.response.PostListResponse;
import sshibko.myblog.api.response.PostResponse;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.service.PostService;
import sshibko.myblog.service.PostServiceImpl;

import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/post")
public class ApiPostController {
    @Autowired
    private final PostServiceImpl postServiceImpl;

    public ApiPostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping("")
    private ResponseEntity<PostListResponse> postList(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "mode", defaultValue = "recent") String mode
    ) {
        return ResponseEntity.ok(postServiceImpl.getPostList(offset, limit, mode));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Post>> getPost(@PathVariable(name = "id") int id) {

        return ResponseEntity.ok(postServiceImpl.getPost(id));
    }
}
