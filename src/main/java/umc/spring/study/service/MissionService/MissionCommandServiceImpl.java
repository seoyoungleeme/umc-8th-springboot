package umc.spring.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.web.dto.MissionRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    // 4. 가게의 미션을 도전 중인 미션에 추가 (미션 도전하기) API
    @Override
    public MemberMission createMemberMission (Long memberId, Long missionId, MissionRequestDTO.createMemberMissionDTO request) {
        MemberMission memberMission = MissionConverter.toMemberMission(request);
        memberMission.setMission(missionRepository.findById(missionId).get());
        memberMission.setMember(memberRepository.findById(memberId).get());

        return memberMissionRepository.save(memberMission);
    }
}