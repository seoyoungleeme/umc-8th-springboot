package umc.spring.study.repository.ReviewRepository;

import umc.spring.study.domain.Review;

public interface ReviewRepositoryCustom {
    boolean existsByMemberAndStore(Long memberId, Long storeId);
    Review saveReview(Review review);
}
