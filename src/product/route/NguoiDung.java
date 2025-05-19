package product.route;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nguoi_dung")
class NguoiDung {
	@RequestMapping(value = "/xoa", method = RequestMethod.DELETE)
	public void xoaNguoiDung() {
	}

	@RequestMapping(value = "/them", method = RequestMethod.POST)
	public void them() {
		
	}

	@RequestMapping(value = "/chinh_sua", method = RequestMethod.PATCH)
	public void chinhSua() {

	}

	@RequestMapping(value = "/xem/{id}", method = RequestMethod.GET)
	public void xem(@PathVariable String id) {

	}
}
