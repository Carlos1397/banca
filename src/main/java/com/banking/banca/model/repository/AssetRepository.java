package com.banking.banca.model.repository;

import com.banking.banca.model.document.Asset;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Class AssetRepository.
 */
@Repository
public interface AssetRepository extends ReactiveMongoRepository<Asset, String> {
}
