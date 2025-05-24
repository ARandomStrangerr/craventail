package product.route;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tu-dien-chuong-trinh")
public class TuDienChuongTrinh {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void danhSach(){}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void them(){}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void xem(@PathVariable String id){}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void chinhSua(@PathVariable String id) {}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void xoa(){}
}
