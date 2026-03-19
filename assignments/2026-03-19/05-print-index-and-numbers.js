import { repeat } from './repeat.js';

const logIndex = (i) => {
  console.log(`index: ${i}`);
};

repeat(3, logIndex);
