package umc.spring.study.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.converter.RegionConverter;
import umc.spring.study.domain.Store;
import umc.spring.study.repository.RegionRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;
import umc.spring.study.web.dto.RegionRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Store createStore (Long regionId, RegionRequestDTO.StoreDTO request) { // 1. 특정 지역에 가게 추가하기 API
        Store store = RegionConverter.toStore(request);
        store.setRegion(regionRepository.findById(regionId).get());

        return storeRepository.save(store);
    }
}

