package umc.spring.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
    Page<Review> getMyReviewList(Long Id, Integer page);
    Page<MemberMission> getMyMissionList(Long Id, Integer page); // 3. 내가 진행 중인 미션 목록 조회하기 API
}
