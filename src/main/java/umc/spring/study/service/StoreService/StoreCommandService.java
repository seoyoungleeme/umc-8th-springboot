package umc.spring.study.service.StoreService;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;

public interface StoreCommandService {

    // 2. 가게에 리뷰 추가하기 API
    Review createReview (Long storeId, StoreRequestDTO.createReviewDTO request);

    // 3. 가게에 미션 추가하기 API
    Mission createMission (Long storeId, StoreRequestDTO.createMissionDTO request);
}