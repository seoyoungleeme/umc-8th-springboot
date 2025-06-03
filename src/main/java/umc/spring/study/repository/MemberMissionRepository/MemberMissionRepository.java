package umc.spring.study.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    Page<MemberMission> findByMemberId(Long memberId, PageRequest of);
}