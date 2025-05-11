package umc.spring.study.service.ReviewService;

import umc.spring.study.domain.Review;

public interface ReviewQueryService {
    Review createReview(Long memberId, Long storeId, String title, float score);
}