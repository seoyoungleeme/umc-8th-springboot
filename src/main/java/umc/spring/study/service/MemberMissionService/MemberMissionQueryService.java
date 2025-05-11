package umc.spring.study.service.MemberMissionService;

import umc.spring.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMission> getMissionsByStatus(Long memberId, String status, int limit, int offset);
}
