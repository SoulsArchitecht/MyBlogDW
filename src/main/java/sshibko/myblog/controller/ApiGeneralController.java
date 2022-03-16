package sshibko.myblog.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sshibko.myblog.api.response.InitResponse;
import sshibko.myblog.api.response.PostResponse;
import sshibko.myblog.api.response.SettingsResponse;
import sshibko.myblog.api.response.TagListResponse;
import sshibko.myblog.service.PostService;
import sshibko.myblog.service.SettingsService;
import sshibko.myblog.service.TagService;

import java.util.List;

@Data
@RestController
// или @Controller + @ResponseBody
@RequestMapping("/api")
public class ApiGeneralController {

    private final SettingsService settingsService;
    private final InitResponse initResponse;
    private final PostService postService;
    private final TagService tagService;


    public ApiGeneralController(SettingsService settingsService, InitResponse initResponse, PostService postService, TagService tagService) {
        this.settingsService = settingsService;
        this.initResponse = initResponse;
        this.postService = postService;
        this.tagService = tagService;
    }

    @GetMapping("/init")
    private InitResponse init() {
        return initResponse;
    }

    @GetMapping("/settings")
    private SettingsResponse settings() {
        return settingsService.getGlobalSettings();
    }

    @GetMapping("/post")
    private List<PostResponse> postList() {
        return postService.getPostList();
    }

    @GetMapping("/post/{id}")
    private PostResponse getPost(@PathVariable(name = "id") int id) {

        return postService.getPost();
    }

    @GetMapping("/tag")
    private List<TagListResponse> tagList() {
        return tagService.getTagListResponseList();
    }


}
