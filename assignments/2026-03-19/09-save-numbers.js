import { repeat } from './repeat.js';

const arr = [];

const saveNumber = (i) => {
  arr.push(i);
};

repeat(10, saveNumber);

console.log(arr);
