package umc.spring.study.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.study.domain.mapping.MemberMission;

public interface MemberMissionRepositoryCustom {
    Page<MemberMission> findMissionsByStatus(Long memberId, String status, Pageable pageable);
}
