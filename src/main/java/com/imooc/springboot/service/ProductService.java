package com.imooc.springboot.service;

import com.imooc.springboot.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.springboot.model.condition.ProductCondition;
import com.imooc.springboot.model.product.ProductAdd;
import com.imooc.springboot.model.product.ProductEdit;
import com.imooc.springboot.model.view.ProductView;
import com.imooc.springboot.utils.Paging;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
public interface ProductService extends IService<Product> {
    List<ProductView> getProductList(ProductCondition condition); //
    Paging<ProductView> getProductPage(ProductCondition condition);
    boolean deleteProduct(int productId);
    Product createProduct(ProductAdd productAdd);
    boolean batchAddProduct(List<ProductAdd> productAdds);
    boolean updateProduct(ProductEdit productEdit);
    void exportProducts(ProductCondition condition, HttpServletResponse response);
}
