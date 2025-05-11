package umc.spring.study.service.MemberMissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.study.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getMissionsByStatus(Long memberId, String status, Pageable pageable);
}
