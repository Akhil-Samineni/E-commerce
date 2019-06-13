package com.emusicstore.controller;

import com.emusicstore.Dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {



    @Autowired
    private ProductDao productDao;
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProduct(Model model){

        List<Product> products= productDao.getAllProducts();
        // Product product=productList.get(0);
        // model.addAttribute(product);

        model.addAttribute("products",products);
        return "productList";
    }

    /**@RequestMapping("/productList/viewProduct")
    public String viewProduct(@ModelAttribute("id") String id){
    System.out.println("Product id is: "+id);
    return "viewProduct";
    }**/
    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable("productId") int productId, Model model) throws IOException {
        System.out.println("Product id is: "+productId);
        Product product= productDao.getProductById(productId);
        model.addAttribute("product",product);
        return "viewProduct";
    }


}
