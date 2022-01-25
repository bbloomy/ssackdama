package ssackdama.ssackdama.service;


import org.springframework.stereotype.Service;
import ssackdama.ssackdama.repository.StoreRepository;
import ssackdama.ssackdama.domain.Store;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAllStores(){

        List<Store> storeList = storeRepository.findAll();

        return storeList;

    }

}
