package main.product.controller;

import main.product.dto.request.MucLucNganSachRequest;
import main.product.entity.MucLucNganSach;
import main.product.service.BaseService;
import main.product.service.MucLucNganSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muc-luc-ngan-sach")
public class MucLucNganSachController extends BaseController<MucLucNganSach, MucLucNganSachRequest> {

	@Autowired
	private MucLucNganSachService mucLucNganSachService;

	@Override
	protected BaseService<MucLucNganSach, MucLucNganSachRequest> getService() {
		return mucLucNganSachService;
	}
}
