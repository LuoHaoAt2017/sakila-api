import {
  Body,
  Controller,
  Get,
  Param,
  Post,
  UseInterceptors,
} from '@nestjs/common';
import { ProductService } from './product.service';
import { Product } from './product.entity';
import { PageDto } from 'src/dtos/PageDto';
import { LoggingInterceptor } from 'src/interceptors/logging.interceptor';

@UseInterceptors(LoggingInterceptor) // 我们传递了 LoggingInterceptor 类（而不是实例），将实例化的责任留给框架并启用依赖注入。
@Controller({
  path: '/product',
})
export class ProductController {
  constructor(private readonly productService: ProductService) {}

  @Get('/detail')
  getProductById(@Param() id: number) {
    return this.productService.findOne(id);
  }

  @Post('/page')
  getProductByPage(@Body() paging: PageDto): Promise<Product[]> {
    return this.productService.findByPage(paging);
  }
}
