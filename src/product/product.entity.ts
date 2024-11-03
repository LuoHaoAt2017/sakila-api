import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity({
  name: 'product',
})
export class Product {
  @PrimaryGeneratedColumn({
    name: 'prod_id',
  })
  id: number;

  @Column({
    name: 'prod_name',
  })
  prodName: string;

  @Column({
    name: 'prod_price',
  })
  prodPrice: number;

  @Column({
    name: 'prod_desc',
  })
  prodDesc: string;

  @Column({
    name: 'deleted',
  })
  isDeleted: number;
}
