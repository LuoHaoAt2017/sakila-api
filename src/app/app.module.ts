import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';
import { DataSource } from 'typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ProductModule } from '../modules/product/product.module';
import { Product } from '../modules/product/product.entity';

@Module({
  imports: [
    ConfigModule.forRoot(),
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'root', // #123456 LuoHao@123
      password: 'LuoHao@123',
      database: 'mybatis_plus',
      entities: [Product],
      synchronize: false, // 设置 synchronize: true 不应在生产中使用 - 否则你可能会丢失生产数据。
    }),
    ProductModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {
  constructor(private dataSource: DataSource) {}
}
