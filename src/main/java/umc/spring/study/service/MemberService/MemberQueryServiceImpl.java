package umc.spring.study.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }
    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return MemberPage;
    }
    @Override
    public Page<MemberMission> getMyMissionList(Long memberId, Integer page) { // 3. 내가 진행 중인 미션 목록 조회하기 API
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> MissionPage = memberMissionRepository.findByMemberId(memberId, PageRequest.of(page, 10));

        return MissionPage;
    }
}

