package umc.spring.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMission> getMissionsByStatus(Long memberId, String status, int limit, int offset) {
        List<MemberMission> missions = memberMissionRepository.findMissionsByStatusAndMemberId(memberId, status, limit, offset);
        missions.forEach(System.out::println);
        return missions;
    }
}
