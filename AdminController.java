package com.emusicstore.controller;


import com.emusicstore.Dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    public Path path;
    @Autowired
    private ProductDao productDao;
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products= productDao.getAllProducts();
        model.addAttribute("products",products);
        return "productInventory";
    }

    @RequestMapping("/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product=new Product();
        product.setProductName("instrument");
        product.setProductCondition("new");
        product.setProductStatus("Active");
        model.addAttribute("product",product);
        return "addProduct";
    }

    @RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, HttpServletRequest request) {

        if(bindingResult.hasErrors()){
            return "addProduct";
        }
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        return "redirect:/admin/productInventory";
    }


    @RequestMapping(value = "/productList/deleteProduct/{id}")
    private String deleteProduct(@PathVariable("id") int id, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image delete failed", e);
            }
        }
        productDao.deleteProduct(id);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Product product= productDao.getProductById(id);
        model.addAttribute(product);
        return "editProduct";
    }

    @RequestMapping(value = "/productInventory/editProduct",method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, Model model,BindingResult bindingResult, HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "editProduct";
        }

        MultipartFile productImage= product.getProductImage();
        String rootdirectory= request.getSession().getServletContext().getRealPath("/");
        path= Paths.get(rootdirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

        if(productImage !=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw  new RuntimeException("Product image saving failed", e);
            }
        }
        productDao.editProduct(product);
        return "redirect:/admin/productInventory";
    }

}
