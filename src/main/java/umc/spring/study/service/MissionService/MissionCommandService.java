package umc.spring.study.service.MissionService;


import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    // 4. 가게의 미션을 도전 중인 미션에 추가 (미션 도전하기) API
    MemberMission createMemberMission (Long memberId, Long missionId, MissionRequestDTO.createMemberMissionDTO request) ;
}

