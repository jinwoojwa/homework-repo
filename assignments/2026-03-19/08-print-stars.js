import { repeat } from './repeat.js';

const logStar = (i) => {
  console.log('*'.repeat(i + 1));
};

repeat(4, logStar);
