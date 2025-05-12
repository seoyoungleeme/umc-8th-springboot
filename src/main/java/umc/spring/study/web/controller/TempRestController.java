package umc.spring.study.web.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.apiPayload.code.ResponseDto;
import umc.spring.study.apiPayload.code.status.SuccessStatus;
import umc.spring.study.converter.TempConverter;
import umc.spring.study.service.TempService.TempQueryService;
import umc.spring.study.web.dto.TempResponse;


@RestController
@RequestMapping("/temp")
//@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    // @Qualifier를 생성자 주입 시 사용
    public TempRestController(@Qualifier("tempQueryServiceImpl") TempQueryService tempQueryService) {
        this.tempQueryService = tempQueryService;
    }

    @GetMapping("/test")
    public ResponseDto<TempResponse.TempTestDTO> testAPI(){

        return ResponseDto.onSuccess(TempConverter.toTempTestDTO(), SuccessStatus._OK.getCode());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}