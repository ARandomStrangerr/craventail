package main.product.controller;

import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.entity.TuDienChuongTrinh;
import main.product.service.BaseService;
import main.product.service.TuDienChuongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tu-dien-chuong-trinh")
public class TuDienChuongTrinhController extends BaseController<TuDienChuongTrinh, TuDienChuongTrinhRequest>{

	@Autowired
	private TuDienChuongTrinhService tuDienChuongTrinhService;

	@Override
	protected BaseService<TuDienChuongTrinh, TuDienChuongTrinhRequest> getService() {
		return tuDienChuongTrinhService;
	}
}
