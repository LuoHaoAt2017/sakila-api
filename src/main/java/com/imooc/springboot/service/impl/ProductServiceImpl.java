package com.imooc.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.springboot.entity.Product;
import com.imooc.springboot.mapper.ProductMapper;
import com.imooc.springboot.model.condition.ProductCondition;
import com.imooc.springboot.model.product.ProductAdd;
import com.imooc.springboot.model.product.ProductEdit;
import com.imooc.springboot.model.view.ProductView;
import com.imooc.springboot.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.springboot.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luo Hao
 * @since 2024-07-08
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Paging<ProductView> getProductPage(ProductCondition condition) {
        Page<ProductView> page = PageUtils.getPage(condition, "prodPrice");
        IPage<ProductView> productPage = productMapper.queryPage(page, condition);
        return new Paging<>(productPage);
    }

    @Override
    public List<ProductView> getProductList(ProductCondition condition) {
        Page<ProductView> page = PageUtils.getPage(condition, "prodPrice");
        IPage<ProductView> productPage =  productMapper.queryPage(page, condition);
        return productPage.getRecords();
    }

    @Override
    public boolean deleteProduct(int productId) {
        int success = productMapper.deleteById(productId);
        return success == 1;
    }

    @Override
    public Product createProduct(ProductAdd productAdd) {
        Product product = new Product();
        BeanUtils.copyProperties(productAdd, product);
        productMapper.insert(product);
        return product;
    }

    @Override
    public boolean batchAddProduct(List<ProductAdd> productAdds) {
        List<Product> productList = new ArrayList<>();
        productAdds.forEach(productAdd -> {
            Product product = new Product();
            BeanUtils.copyProperties(productAdd, product);
            productList.add(product);
        });
        return this.saveBatch(productList);
    }

    @Override
    public boolean updateProduct(ProductEdit productEdit) {
        Product product = new Product();
        BeanUtils.copyProperties(productEdit, product);
        return productMapper.updateById(product) == 1;
    }

    @Override
    public void exportProducts(ProductCondition condition, HttpServletResponse response) {
        String fileName = DateUtils.now(DateUtils.DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS) + ".xlsx";
        String sheetName = "Product List";
        List<List<String>> sheetRowList = new ArrayList<>();
        // 添加列数据
        addHeaderColumns(sheetRowList);
        // 添加行数据
        addRowColumns(condition, sheetRowList);
        // 导出数据
        ExcelWriterUtils.exportExcels(response, fileName, sheetName, sheetRowList);
    }

    private void addHeaderColumns(List<List<String>> sheetRowList) {
        // 解决硬编码问题，采用国际化方案。
        List<String> rowColumns = Arrays.asList(
                MessageUtils.processMessage("product.prodId"),
                MessageUtils.processMessage("product.prodName"),
                MessageUtils.processMessage("product.prodPrice"),
                MessageUtils.processMessage("product.prodDesc"),
                MessageUtils.processMessage("vendor.vendName"));
        sheetRowList.add(rowColumns);
    }

    private void addRowColumns(ProductCondition condition, List<List<String>> sheetRowList) {
        List<ProductView> productList = getProductList(condition);
        productList.forEach(item -> {
            List<String> rowColumns = new ArrayList<>();
            rowColumns.add(item.getProdId().toString());
            rowColumns.add(item.getProdName());
            rowColumns.add(item.getProdPrice().toString());
            rowColumns.add(item.getProdDesc());
            rowColumns.add(item.getVendName());
            sheetRowList.add(rowColumns);
        });
    }
}
