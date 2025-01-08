package org.hoaithanh.student_management.controller;

import org.hoaithanh.student_management.entity.SinhVien;
import org.hoaithanh.student_management.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sinhviens")
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping
    public String viewSinhViens(Model model) {
        List<SinhVien> sinhViens = sinhVienService.getAllSinhViens();
        model.addAttribute("sinhViens", sinhViens);
        return "sinhvien-list";
    }

//    @GetMapping("/{id}")
//    public String viewProduct(@PathVariable Long id, Model model) {
//        Optional<Product> product = sinhVienService.getProductById(id);
//        product.ifPresent(p -> model.addAttribute("product", p));
//        return "productDetail";
//    }
//
//    @PostMapping("/add")
//    public String addProduct(Product product) {
//        sinhVienService.addProduct(product);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        sinhVienService.deleteProduct(id);
//        return "redirect:/products";
//    }
}

