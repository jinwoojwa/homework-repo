## Vue.js Gramma 개념 정리

### 1.선언적 렌더링

`선언적 렌더링`이란 "무엇을 화면에 보여줄지"만 선언하면, "어떻게" DOM을 조작할지는 프레임워크가 알아서 처리하는 렌더링 방식이다.

```html
<div id="app">{{ message }}</div>
```

```JavaScript
data() {
  return {
    message: "Hello"
  }
}
```

위의 예시에서 개발자가 `<div>` 태그 안에 `message`라는 값을 보여줄 것이라고 선언하기만 하면,

프레임워크(Vue)는 내부적으로 해당 데이터를 실제 DOM에 렌더링한다.

즉, 개발자가 직접 DOM을 선택하고 값을 넣는 작업을 하지 않아도 된다.

<br>

반대로, 전통적인 방식(명령형 렌더링)에서는 다음과 같이 직접 DOM을 조작해야 한다.

```JavaScript
const el = document.getElementById("app");
el.innerText = "Hello";
```

<br><br>

### 데이터 바인딩 (v-bind, v-model)

- `v-bind`
  - `<abbr v-bind:title="normal">{{ abbr }}</abbr>`
  - 데이터를 화면에 반영만, 입력으로 변경되지는 않음
  - normal 값이 title 속성에 단방향으로 전달됨
  - `v-bind:title` == `:title`

- `v-model`
  - 양방향 바인딩
  - `<input v-model="abbr" />` 에서 입력창의 값 ↔ abbr 데이터가 양방향으로 연결

<br><br>

### 이벤트 리스너

- `v-on` 디렉티브 (`= @`)를 사용하여 DOM 이벤트를 리스닝하고, 이벤트가 발생할 때 자바스크립트 실행 가능
- `v-on:click="handler"` 또는 `@click="handler"` 로 사용 가능
- 핸들러 값은 다음 중 하나임
  - 인라인 핸들러

  ```javascript
  <button @click="count++">Add 1</button>
  <p>Count is: {{ count }}</p>
  ```

  - 메서드 핸들러

  ```javascript
  const name = ref('Vue.js');

  function greet(event) {
    alert(`Hello ${name.value}!`);
    // `event`는 네이티브 DOM 이벤트입니다
    if (event) {
      alert(event.target.tagName);
    }
  }
  <button @click="greet">Greet</button>
  ```

<br><br>

### 조건부 렌더링 (v-if)

- `v-if` 디렉티브를 통해 블록을 조건부로 렌더링할 수 있음
- 디렉티브의 표현식이 참 값을 반환할 때만 블록이 렌더링됨
- `v-else-if`, `v-else` 와 같은 요소 또한 사용 가능

<br><br>

### 리스트 렌더링 (v-for)

- `v-for` 디렉티브를 사용하여 배열 객체 등을 기반으로 목록을 렌더링할 수 있음
- `item in items` 형태의 문법으로 사용되며, `items`는 소스 데이터 배열, `item`은 반복되는 배열 요소임
- 배열뿐만 아니라, 객체, 정수 범위로 반복도 가능

```JavaScript
// 배열
const items = ref([{ message: 'Foo' }, { message: 'Bar' }])

<li v-for="item in items">
  {{ item.message }}
</li>

// 객체
const items = reactive({ 1: '1번 객체', 2: '2번 객체', 3: '3번 객체' });

<li v-for="item in items">{{ item }}</li>

// 정수

<span v-for="n in 10">{{ n }}</span> // 1부터 시작
```

<br><br>

### 계산된 속성

- 데이터를 기반으로 계산된 값을 정의하는 기능
- 핵심은 캐싱 + 반응성 기반 자동 갱신

  ```JavaScript
  const count = ref(1)

  const double = computed(() => count.value * 2)
  ```

- `count`가 바뀌면, `double`도 자동으로 다시 계산됨
- 값이 바뀌지 않으면, 재계산 X (캐싱)
- 메서드로도 구현 가능하지만, `computed`는 데이터가 변경될 때만 다시 계산하고, 메서드는 호출될때마다 실행
- 계산된 속성에서 반환된 값은 일종의 임시 스냅샷
- 소스 상태가 변경될 때마다 새로운 스냅샷이 생성됨
