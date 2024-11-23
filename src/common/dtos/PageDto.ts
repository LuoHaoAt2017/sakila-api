import { IsNumber, IsPositive, Max, Min } from 'class-validator';

export class PageDto {
  @IsNumber()
  @IsPositive()
  @Max(100)
  @Min(5)
  pageSize: number;

  @IsNumber()
  @IsPositive()
  curPage: number;
}
