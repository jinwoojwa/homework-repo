import { createRouter, createWebHistory } from 'vue-router';

import About from '../pages/About.vue';
import Home from '../pages/Home.vue';
import Members from '../pages/Members.vue';
import Videos from '../pages/Videos.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'home', component: Home },
    { path: '/about', name: 'about', component: About },
    { path: '/members', name: 'members', component: Members },
    { path: '/videos', name: 'videos', component: Videos },
  ],
});

export default router;
