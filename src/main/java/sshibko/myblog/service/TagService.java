package sshibko.myblog.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.TagListResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class TagService {

    //temporary stopper before DB injection
    private List<TagListResponse> tagListResponseList;



}
