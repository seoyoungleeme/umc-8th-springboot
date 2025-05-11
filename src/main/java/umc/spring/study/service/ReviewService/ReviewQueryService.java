package umc.spring.study.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.study.domain.Review;

public interface ReviewQueryService {
    Page<Review> getReviewsByStore(Long storeId, Pageable pageable);
}
