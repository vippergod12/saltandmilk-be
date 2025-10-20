package saltandmilk.services.tag;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import saltandmilk.dto.response.tag.TagResponseDto;
import saltandmilk.entities.tag.Tag;
import saltandmilk.intefaces.tag.TagService;
import saltandmilk.mappers.TagMapper;
import saltandmilk.repositories.tag.TagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagServiceImp implements TagService {

    final TagRepository tagRepository;
    final TagMapper tagMapper;
    @Override
    public List<TagResponseDto> findAll() {
        List<Tag> tags = tagRepository.findAll();
        return tagMapper.toTagResponseDto(tags);
    }
}
