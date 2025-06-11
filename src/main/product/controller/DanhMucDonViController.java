package main.product.controller;

import main.product.dto.request.DanhMucDonViRequest;
import main.product.entity.DanhMucDonVi;
import main.product.service.BaseService;
import main.product.service.DanhMucDonViService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/danh-muc-don-vi")
public class DanhMucDonViController extends BaseController<DanhMucDonVi, DanhMucDonViRequest> {
    @Autowired
    private DanhMucDonViService danhMucDonViService;

    @Override
    protected BaseService<DanhMucDonVi, DanhMucDonViRequest> getService() {
        return danhMucDonViService;
    }
} 