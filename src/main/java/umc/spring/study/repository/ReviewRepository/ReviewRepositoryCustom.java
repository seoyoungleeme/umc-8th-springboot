package umc.spring.study.repository.ReviewRepository;

import umc.spring.study.domain.Review;

public interface ReviewRepositoryCustom {
    Review saveReview(Long memberId, Long storeId, String title, float score);
}
