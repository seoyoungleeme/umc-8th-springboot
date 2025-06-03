package umc.spring.study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.RegionConverter;
import umc.spring.study.domain.Store;
import umc.spring.study.service.RegionService.RegionCommandService;
import umc.spring.study.validation.annotation.ExistRegion;
import umc.spring.study.web.dto.RegionRequestDTO;
import umc.spring.study.web.dto.RegionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionRestController {

    private final RegionCommandService regionCommandService;

    @PostMapping("/{regionId}/store") // 1. 특정 지역에 가게 추가하기 API
    public ApiResponse<RegionResponseDTO.CreateStoreResultDTO> createStore (@RequestBody @Valid RegionRequestDTO.StoreDTO request,
                                                                            @ExistRegion @PathVariable(name = "regionId") Long regionId) {
        Store store = regionCommandService.createStore(regionId, request);

        return ApiResponse.onSuccess(RegionConverter.toCreateStoreResultDTO(store));
    }
}

