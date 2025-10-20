package saltandmilk.intefaces.tag;

import saltandmilk.dto.response.tag.TagResponseDto;

import java.util.List;

public interface TagService {
    List<TagResponseDto> findAll();
}
