import { Injectable } from '@nestjs/common';

@Injectable()
export class AppService {
  getHello(): string {
    console.log('DATABASE_USER: ', process.env.DATABASE_USER);
    console.log('DATABASE_PASSWORD: ', process.env.DATABASE_PASSWORD);
    return 'Hello World!';
  }
}
