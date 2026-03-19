console.log('A');

setTimeout(() => {
  console.log('B');
}, 0);

console.log('C');

/*
실행 결과 : A -> C -> B

이유:
setTimeout의 대기 시간이 0초임에도 불구하고 A->B->C가 아닌 A->C->B인 이유는
비동기 처리 함수의 경우 별도의 콜백 큐에 들어가므로 콜 스택이 모두
비워진 후 이벤트 루프에 의해 콜 스택으로 이동하여 처리되기 때문에 가장 늦게 출력됩니다.
*/
