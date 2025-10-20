package saltandmilk.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import saltandmilk.dto.request.tag.TagRequestDto;
import saltandmilk.dto.response.tag.TagResponseDto;
import saltandmilk.entities.tag.Tag;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
//    @Mapping(source = "")
    Tag toTag(TagRequestDto request);

    TagResponseDto  toTagResponseDto(Tag tag);

    List<TagResponseDto> toTagResponseDto(List<Tag> tags);

    // Dạy cho MapStruct cách tạo một đối tượng Tag từ một ID
    default Tag fromId(Integer tagId) {
        if (tagId == null) {
            return null;
        }
        Tag tag = new Tag();
        tag.setTag_id(tagId);
        return tag;
    }
}
