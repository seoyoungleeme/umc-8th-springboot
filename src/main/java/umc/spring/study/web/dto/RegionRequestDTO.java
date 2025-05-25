package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class RegionRequestDTO {

    @Getter
    public static class StoreDTO { // 1. 특정 지역에 가게 추가하기 API
        @NotBlank
        private String name;
        @NotBlank
        private String address;
    }
}