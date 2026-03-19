function myForEach(arr, callback) {
  arr.forEach((index, item) => {
    callback(index, item);
  });
}

myForEach(['a', 'b', 'c'], function (item, index) {
  console.log(`Index ${index}: ${item}`);
});
