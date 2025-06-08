package main.product.controller;

import main.product.dto.request.DoiTuongKinhTeRequest;
import main.product.entity.DoiTuongKinhTe;
import main.product.service.BaseService;
import main.product.service.DoiTuongKinhTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doi-tuong-kinh-te")
public class DoiTuongKinhTeController extends BaseController<DoiTuongKinhTe, DoiTuongKinhTeRequest> {
    @Autowired
    private DoiTuongKinhTeService doiTuongKinhTeService;

    @Override
    protected BaseService<DoiTuongKinhTe, DoiTuongKinhTeRequest> getService() {
        return doiTuongKinhTeService;
    }
}