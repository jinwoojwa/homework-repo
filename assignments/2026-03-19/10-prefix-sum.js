import { repeat } from './repeat.js';

let sum = 0;

const add = (i) => {
  sum += i;
};

repeat(10, add);

console.log(sum);
