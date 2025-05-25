package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createMemberMissionResultDTO { // 4. 가게의 미션을 도전 중인 미션에 추가 (미션 도전하기) API
        private Long id;
        private LocalDateTime createdAt;
    }
}
