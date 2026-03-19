function filterLog(arr, callback) {
  for (const num of arr) {
    if (callback(num)) console.log(num);
  }
}

filterLog([1, 2, 3, 4, 5], function (x) {
  return x % 2 === 0;
});
