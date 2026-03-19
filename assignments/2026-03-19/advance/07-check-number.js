function checkNumber(num, onSuccess, onFail) {
  if (num > 10) {
    onSuccess();
  } else onFail();
}

checkNumber(
  5,
  () => console.log('성공'),
  () => console.log('실패'),
);
