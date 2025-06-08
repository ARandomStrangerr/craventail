package main.product.controller;

import main.product.dto.request.TaiKhoanDungRequest;
import main.product.entity.TaiKhoanDung;
import main.product.service.BaseService;
import main.product.service.TaiKhoanDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tai-khoan-dung")
public class TaiKhoanDungController extends BaseController<TaiKhoanDung, TaiKhoanDungRequest> {

	@Autowired
	private TaiKhoanDungService taiKhoanDungService;

	@Override
	protected BaseService<TaiKhoanDung, TaiKhoanDungRequest> getService() {
		return taiKhoanDungService;
	}
}
