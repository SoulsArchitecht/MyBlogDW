package sshibko.myblog.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.TagListResponse;
import sshibko.myblog.api.response.TagResponse;
import sshibko.myblog.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Service
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    /**temporary stopper before DB injection */
    public TagListResponse tagResponseList() {
        List<TagResponse> tagListResponses = new ArrayList<>();
        tagRepository.findAll().forEach(t -> tagListResponses.add(new TagResponse(t.getName(), getTagWeight())));
        return new TagListResponse(tagListResponses);
    }

    /** temporary stopper */
    private double getTagWeight() {
        return Math.random() ;
    }

}
