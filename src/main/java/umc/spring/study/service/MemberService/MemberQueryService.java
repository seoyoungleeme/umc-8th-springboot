package umc.spring.study.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.web.dto.MemberResponseDTO;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
    // MemberQueryService.java
    Page<Review> getMyReviewList(Long memberId, Integer page);
    Page<MemberMission> getMyMissionList(Long Id, Integer page); // 3. 내가 진행 중인 미션 목록 조회하기 API
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
