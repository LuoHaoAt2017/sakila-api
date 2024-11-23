import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Product } from './product.entity';
import { Repository } from 'typeorm';
import { PageDto } from 'src/common/dtos/PageDto';

@Injectable()
export class ProductService {
  constructor(
    @InjectRepository(Product)
    private productRepository: Repository<Product>,
  ) {}

  findAll(): Promise<Product[]> {
    return this.productRepository.find();
  }

  findByPage(pageParam: PageDto): Promise<Product[]> {
    return this.productRepository.find({
      skip: (pageParam.curPage - 1) * pageParam.pageSize,
      take: pageParam.pageSize,
    });
  }

  findOne(id: number): Promise<Product | null> {
    return this.productRepository.findOneBy({ id });
  }

  async remove(id: number): Promise<boolean> {
    const result = await this.productRepository.delete(id);
    return result.affected === 1;
  }
}
