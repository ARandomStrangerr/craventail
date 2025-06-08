package main.product.controller;

import main.product.dto.request.TuDienCongTrinhRequest;
import main.product.entity.TuDienCongTrinh;
import main.product.service.BaseService;
import main.product.service.TuDienCongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tu-dien-cong-trinh")
public class TuDienCongTrinhController extends BaseController<TuDienCongTrinh, TuDienCongTrinhRequest> {

	@Autowired
	private TuDienCongTrinhService tuDienCongTrinhService;

	@Override
	protected BaseService<TuDienCongTrinh, TuDienCongTrinhRequest> getService() {
		return tuDienCongTrinhService;
	}
}
