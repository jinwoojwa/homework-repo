<script>
import { reactive, computed } from 'vue';
export default {
  setup() {
    const state = reactive({ isNavShow: false });
    const navClass = computed(() => {
      state.isNavShow
        ? 'collapse navbar-collapse show'
        : 'collapse navbar-collapse';
    });
    const changeIsNavShow = () => {
      state.isNavShow = !state.isNavShow;
    };
    return { state, changeIsNavShow, navClass };
  },
};
</script>
<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">이날치(LeeNalchi)</router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#mainNavbar"
        aria-controls="mainNavbar"
        aria-expanded="false"
        aria-label="메뉴 열기"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="mainNavbar">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link class="nav-link" to="/">홈</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/about">소개</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/members">멤버</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/videos">영상</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
