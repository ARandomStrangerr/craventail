package main.product.controller;

import main.product.dto.request.DonViRequest;
import main.product.entity.DonVi;
import main.product.service.BaseService;
import main.product.service.DonViService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/don-vi")
public class DonViController extends BaseController<DonVi, DonViRequest> {
    @Autowired
    private DonViService donViService;

    @Override
    protected BaseService<DonVi, DonViRequest> getService() {
        return donViService;
    }
}
