import { createRouter, createWebHistory } from 'vue-router';
import Login from '../pages/login/login.vue';
import Index from '../pages/index/index.vue';

const routes = [
  {
    path: '/',
    name: 'login',
    component: Login,
  },
  {
    path: '/index',
    name: 'index',
    component: Index,
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;