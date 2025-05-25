package umc.spring.study.web.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.study.domain.enums.MissionStatus;

public class MissionRequestDTO {

    @Getter
    public static class createMemberMissionDTO { // 4. 가게의 미션을 도전 중인 미션에 추가 (미션 도전하기) API
        @NotNull
        private MissionStatus status;
    }
}

