package com.banking.banca.api;

import com.banking.banca.model.document.Asset;
import com.banking.banca.model.document.Card;
import com.banking.banca.model.document.Passive;
import com.banking.banca.model.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @GetMapping()
    public Flux<Asset> getAllAsset() {
        return assetService.getAll();
    }

    @PostMapping
    public Mono<Asset> register(@RequestBody Asset asset) {
        return  assetService.save(asset);
    }

    @GetMapping("/{id}")
    public Mono<Asset> getAsset(@PathVariable String id) {
        return  assetService.findById(id);
    }
}
