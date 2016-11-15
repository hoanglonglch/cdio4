package com.guru.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.entities.CartEntity;
import com.guru.entities.ProductEntity;
import com.guru.service.ParentEntityManager;
import com.guru.service.ProductEntityManager;

@Controller
@RequestMapping(value = "/")
public class CartController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	ParentEntityManager parentEntityManager;
	@Autowired
	ProductEntityManager productEntityManager;
	@ModelAttribute("parent")
	public void parent(ModelMap model){
		model.addAttribute("parent",parentEntityManager.getAllParent());
	}
	@RequestMapping(value = "/cart/remove", method = RequestMethod.GET)
	public String cartRemove(@RequestParam(value = "product_id") String id, HttpSession session){
		@SuppressWarnings("unchecked")
		List<CartEntity> carts = (List<CartEntity>)session.getAttribute("cartSession");
		if(carts != null){
			int index = isExisting(id, session);
			carts.remove(index);
		}
		session.setAttribute("total", getTotal(carts));
		session.setAttribute("cartSession", carts);
		return "cartPage";
	}
	@RequestMapping(value = "/cart/update", method = RequestMethod.POST)
	public String cartUpdate(HttpServletRequest request, HttpSession session){
		@SuppressWarnings("unchecked")
		List<CartEntity> carts = (List<CartEntity>)session.getAttribute("cartSession");
		String []quantity = request.getParameterValues("quantity");
		for(int i = 0; i < carts.size(); i++){
			carts.get(i).setQuantity(Integer.parseInt(quantity[i]));
		}
		session.setAttribute("total", getTotal(carts));
		session.setAttribute("cartSession", carts);
		return "cartPage";
	}
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(ModelMap modelMap) {
		return "cartPage";
		
	}
	@RequestMapping(value = "/cart/addCart", method = RequestMethod.GET)
	public String cartAdd(@RequestParam("product_id")String id,ModelMap modelMap,
			HttpSession session) {
		ProductEntity productEntity = productEntityManager.findOne(id);
		int quantity;
		if(session.getAttribute("cartSession") == null){
			List<CartEntity> carts = new ArrayList<CartEntity>();
			quantity = 1;
			carts.add(new CartEntity(productEntity,quantity));
			for(CartEntity cart : carts){
				System.out.println(cart.getProductEntity().getName()+cart.getProductEntity().getPrice()+"\n");
			}
			session.setAttribute("total", getTotal(carts));
			session.setAttribute("cartSession", carts);
			
		}else{
			@SuppressWarnings("unchecked")
			List<CartEntity> carts = (List<CartEntity>)session.getAttribute("cartSession");
			quantity = 1;
			int index = isExisting(id, session);
			if(index == -1){
				carts.add(new CartEntity(productEntity,quantity));
			}else{
				carts.get(index).setQuantity(carts.get(index).getQuantity() + 1);
				System.out.println(carts.get(index).getProductEntity().getName()+carts.get(index).getProductEntity().getPrice()+"\n" +"\n"+ carts.get(index).getQuantity());
			}
			session.setAttribute("total", getTotal(carts));
			session.setAttribute("cartSession", carts);
		}
		return "cartPage";
	}
	private int isExisting(String id, HttpSession session){
		@SuppressWarnings("unchecked")
		List<CartEntity> carts = (List<CartEntity>)session.getAttribute("cartSession");
		for(int i = 0; i < carts.size(); i++){
			if(carts.get(i).getProductEntity().getId().equals(id)){
				return i;
			}
		}
		return -1;
	}
	public float getTotal(List<CartEntity> list){
		float total = 0;
		for(CartEntity cart : list){
			total += cart.getQuantity() * cart.getProductEntity().getPrice();
		}
		return total;
	}
}
