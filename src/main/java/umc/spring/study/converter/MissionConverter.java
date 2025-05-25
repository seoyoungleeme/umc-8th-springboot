package umc.spring.study.converter;

import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MissionRequestDTO;
import umc.spring.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    // 4. 가게의 미션을 도전 중인 미션에 추가 (미션 도전하기) API
    public static MemberMission toMemberMission(MissionRequestDTO.createMemberMissionDTO request) {
        return MemberMission.builder()
                .status(request.getStatus())
                .build();
    }
    public static MissionResponseDTO.createMemberMissionResultDTO createMemberMissionResultDTO (MemberMission memberMission) {
        return MissionResponseDTO.createMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
