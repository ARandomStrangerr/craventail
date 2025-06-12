package main.product.controller;

import main.product.dto.request.SoDuRequest;
import main.product.entity.SoDu;
import main.product.service.BaseService;
import main.product.service.SoDuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/so-du")
public class SoDuController extends BaseController<SoDu, SoDuRequest> {
    @Autowired
    private SoDuService soDuService;

    @Override
    protected BaseService<SoDu, SoDuRequest> getService() {
        return soDuService;
    }
} 