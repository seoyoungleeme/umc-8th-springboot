package umc.spring.study.repository.MemberMissionRepository;

import umc.spring.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findMissionsByStatusAndMemberId(Long memberId, String status, int limit, int offset);
}