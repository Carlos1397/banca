package com.banking.banca.service;

import com.banking.banca.model.document.Asset;
import com.banking.banca.model.repository.AssetRepository;
import com.banking.banca.model.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class AssetServiceImpl.
 */
@Service
public class AssetServiceImpl implements AssetService {

  @Autowired
  private AssetRepository assetRepository;

  @Override
  public Flux<Asset> getAll() {
    return assetRepository.findAll();
  }

  @Override
  public Mono<Asset> save(Asset asset) {
    return assetRepository.save(asset);
  }

  @Override
  public Mono<Asset> update(String id, Asset asset) {
    return null;
  }

  @Override
  public Mono<Asset> findById(String id) {
    return assetRepository.findById(id);
  }

  @Override
  public Mono<Void> delete(String id) {
    return assetRepository.deleteById(id);
  }
}
