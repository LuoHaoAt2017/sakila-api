package com.imooc.springboot.controller;

import com.imooc.springboot.annotation.HasPermission;
import com.imooc.springboot.entity.Product;
import com.imooc.springboot.model.condition.ProductCondition;
import com.imooc.springboot.model.product.ProductAdd;
import com.imooc.springboot.model.product.ProductEdit;
import com.imooc.springboot.model.view.ProductView;
import com.imooc.springboot.service.ProductService;
import com.imooc.springboot.utils.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.imooc.springboot.constants.PermissionConst.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/page")
    public Paging<ProductView> getProductByPage(@RequestBody ProductCondition condition) {
        return productService.getProductPage(condition);
    }

    @PostMapping(value = "/list")
    public List<ProductView> getProductByList(@RequestBody ProductCondition condition) {
        return productService.getProductList(condition);
    }

    @DeleteMapping(value = "/delete/{id}")
    @HasPermission({ product_delete })
    public boolean deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PostMapping(value = "/add")
    public Product addProduct(@RequestBody @Validated ProductAdd productAdd) {
        return productService.createProduct(productAdd);
    }

    @PostMapping(value = "/batch/add")
    public boolean batchAddProduct(@RequestBody @Validated List<ProductAdd> productList) {
        return productService.batchAddProduct(productList);
    }

    @PutMapping(value = "/edit")
    public boolean editProduct(@RequestBody @Validated ProductEdit productEdit) {
        return productService.updateProduct(productEdit);
    }

//    @ApiOperation("导出商品列表")
    @PostMapping(value = "/export")
    public void exportProducts(@RequestBody ProductCondition condition, HttpServletResponse response) {
        productService.exportProducts(condition, response);
    }
}
