setTimeout(function () {
  console.log('1');
  setTimeout(function () {
    console.log('2');
    setTimeout(function () {
      console.log('3');
    }, 1000);
  }, 1000);
}, 1000);

/*
문제점:
콜백 함수를 중첩해서 사용하여 코드의 가독성이 떨어지고, 흐름을 파악하기 어렵다.

개선 방안:
1. 콜백 함수를 외부로 분리한다.
2. Promise 사용
3. async/await 사용
*/

// 개선 방안 1. 외부로 분리

function print3() {
  console.log('3');
}

function print2() {
  console.log('2');
  setTimeout(print3, 1000);
}

function print1() {
  console.log('1');
  setTimeout(print2, 1000);
}

setTimeout(print1, 1000);

// 개선 방안 2. Promise 사용

function stop(ms) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}

stop(1000)
  .then(() => {
    console.log('1');
    return stop(1000);
  })
  .then(() => {
    console.log('2');
    return delay(1000);
  })
  .then(() => {
    console.log('3');
  })
  .catch((error) => {
    console.log(error);
  });

// 개선 방안 3. async/await 사용

function stop(ms) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}

async function runCode() {
  await stop(1000);
  console.log('1');

  await stop(1000);
  console.log('2');

  await stop(1000);
  console.log('3');
}

runCode();
