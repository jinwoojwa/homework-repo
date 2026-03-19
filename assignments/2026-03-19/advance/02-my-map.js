function myMap(arr, callback) {
  return arr.map(callback);
}

const result = myMap([1, 2, 3], function (x) {
  return x * 2;
});

console.log(result);

// function myMap(arr, callback) {
//   const newArr = [];

//   for (let i = 0; i < arr.length; ++i) {
//     newArr.push(callback(arr[i]));
//   }
//   return ;
// }
