package saltandmilk.controllers.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.request.product.ColorRequestDto;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.product.ColorResponseDto;
import saltandmilk.intefaces.product.ColorService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;
    @GetMapping("/colors")
    ApiResp<List<ColorResponseDto>> getAll(){
        var result = colorService.findAll();
        return ApiResp.<List<ColorResponseDto>>builder().result(result).build();
    }
}
