package umc.spring.study.web.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class StoreRequestDTO {

    @Getter
    @Setter
    public static class createReviewDTO {
        private String body;
        private int score;
    }

    @Getter
    @Setter
    public static class createMissionDTO {
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private String store;
    }
}