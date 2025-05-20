package product.route;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tai_khoan")
public class KhaiBaoTaiKhoan {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void macDinh(){}

	@RequestMapping(value = "/xoa", method = RequestMethod.DELETE)
	public void xoa(){}

	@RequestMapping(value = "/them", method = RequestMethod.POST)
	public void them(){}

	@RequestMapping(value = "/chinh_sua/{id}", method = RequestMethod.PATCH)
	public void chinhSua(@PathVariable String id) {}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void xem(@PathVariable String id){}
}
