import { repeat } from './repeat.js';

const logSquare = (i) => {
  console.log(i ** 2);
};

repeat(5, logSquare);
