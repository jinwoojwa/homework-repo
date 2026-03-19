import { repeat } from './repeat.js';

const logEven = (i) => {
  if (i % 2 === 0) console.log(i);
};

repeat(10, logEven);
