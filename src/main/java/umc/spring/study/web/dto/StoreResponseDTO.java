package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createReviewResultDTO { // 2. 가게에 리뷰 추가하기 API
        private Long reviewId;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createMissionResultDTO { // 3. 가게에 미션 추가하기 API
        private Long missionId;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO { // 특정 가게의 리뷰 목록 조회하기 API
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDTO { // 2. 특정 가게의 미션 목록 조회하기 API
        String storeName;
        Integer reward;
        String missionSpec;
        LocalDate createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        List<MissionPreViewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
