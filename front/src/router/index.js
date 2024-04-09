import { createRouter, createWebHistory } from 'vue-router';
import Login from '../pages/login/login.vue';
import Index from '../pages/index/index.vue';
import Edit_Ingredient from '../pages/edit_ingredient/edit_ingredient.vue';
import Create_Recipe from '../pages/creator_recipe/creator_recipe.vue'
import Camera_Result from '../pages/camera_result/camera_result.vue'

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
  {
    path: '/edit_ingredient',
    name: 'edit_ingredient',
    component: Edit_Ingredient,
  },
  {
    path: '/creator_recipe',
    name: 'creator_recipe',
    component: Create_Recipe,
  },
  {
    path: '/camera_result',
    name: 'camera_result',
    component: Camera_Result,
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;