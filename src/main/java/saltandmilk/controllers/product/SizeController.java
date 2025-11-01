package saltandmilk.controllers.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.product.SizeResponseDto;
import saltandmilk.intefaces.product.SizeService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SizeController {
    final SizeService sizeService;
    @GetMapping("/sizes")
    ApiResp<List<SizeResponseDto>> findAll() {
        var result = sizeService.findAll();
        return ApiResp.<List<SizeResponseDto>>builder().result(result).build();
    }
}
