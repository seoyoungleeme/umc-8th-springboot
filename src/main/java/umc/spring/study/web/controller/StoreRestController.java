package umc.spring.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.service.StoreService.StoreQueryService;
import umc.spring.study.validation.annotation.ExistStore;
import umc.spring.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreQueryService storeQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징 포함. query String 으로 page 번호")
    // API에 대한 설명
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    // API 응답. error 상황에 대해 content로 형태 알려주고(result 필요없음) 성공은 content 지정 x (성공시, DTO가 응답 형태로 나감)
    @Parameters({ //프론트에서 넘겨줘야할 정보
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page) {

        var reviewList = storeQueryService.getReviewList(storeId, page);

        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}