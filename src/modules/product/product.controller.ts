import { Body, Controller, Get, Post } from '@nestjs/common';
import { ProductService } from './product.service';
import { Product } from './product.entity';
import { PageDto } from 'src/dtos/PageDto';

@Controller({
  path: '/product',
})
export class ProductController {
  constructor(private readonly productService: ProductService) {}

  @Post('/page')
  getProductByPage(@Body() paging: PageDto): Promise<Product[]> {
    return this.productService.findByPage(paging);
  }
}
