package sshibko.myblog.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshibko.myblog.api.response.PostListResponse;
import sshibko.myblog.api.response.PostResponse;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.service.PostService;

@Data
@RestController
@RequestMapping("/api/post")
public class ApiPostController {

    private final PostService postService;

    @GetMapping("")
    private ResponseEntity<PostListResponse> postList(
            @RequestParam(name = "offset") int offset,
            @RequestParam(name = "limit") int limit,
            @RequestParam(name = "mode") String mode
    ) {
        return ResponseEntity.ok(postService.getPostList(offset, limit, mode));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Post> getPost(@PathVariable(name = "id") int id) {

        return ResponseEntity.ok(postService.getPost(id));
    }
}
