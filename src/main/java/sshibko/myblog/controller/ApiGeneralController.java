package sshibko.myblog.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sshibko.myblog.api.response.*;
import sshibko.myblog.service.PostServiceImpl;
import sshibko.myblog.service.GlobalSettingsServiceImpl;
import sshibko.myblog.service.TagServiceImpl;

import java.util.List;

@Data
@RestController
// или @Controller + @ResponseBody
@RequestMapping("/api")
public class ApiGeneralController {
    @Autowired
    private final GlobalSettingsServiceImpl globalSettingsServiceImpl;
    @Autowired
    private final InitResponse initResponse;
    @Autowired
    private final PostServiceImpl postServiceImpl;
    @Autowired
    private final TagServiceImpl tagServiceImpl;


    public ApiGeneralController(GlobalSettingsServiceImpl globalSettingsServiceImpl, InitResponse initResponse, PostServiceImpl postServiceImpl, TagServiceImpl tagServiceImpl) {
        this.globalSettingsServiceImpl = globalSettingsServiceImpl;
        this.initResponse = initResponse;
        this.postServiceImpl = postServiceImpl;
        this.tagServiceImpl = tagServiceImpl;
    }

    @GetMapping("/init")
    private ResponseEntity<InitResponse> init() {
        return ResponseEntity.ok(initResponse);
    }

    @GetMapping("/settings")
    private ResponseEntity<GlobalSettingsResponse> settings() {
        return ResponseEntity.ok(globalSettingsServiceImpl.getGlobalSettingsResponse());
    }

    @GetMapping("/tag")
    public ResponseEntity<TagListResponse> tagList() {
        return ResponseEntity.ok(tagServiceImpl.tagResponseList());
    }


}
