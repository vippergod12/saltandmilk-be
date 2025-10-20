package saltandmilk.controllers.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.tag.TagResponseDto;
import saltandmilk.entities.tag.Tag;
import saltandmilk.intefaces.tag.TagService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TagController {

    final TagService tagService;

    @GetMapping("/product-tag")
    ApiResp<List<TagResponseDto>> findAll(){
        var result =  tagService.findAll();
        return ApiResp.<List<TagResponseDto>>builder().result(result).build();
    }

}
