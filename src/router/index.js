import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import AddCategory from '../views/category/AddCategory'
import Category from '../views/category/Category'
import EditCategory from '../views/category/EditCategory'
import AddProduct from '../views/product/AddProduct'
import Product from '../views/product/Product'
import EditProduct from '../views/product/EditProduct'
import ShowDetails from '../views/product/ShowDetails'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: () =>
        import('../views/About.vue'),
  },
  {
    path: '/admin/category',
    name: 'AdminCategory',
    component: Category,
  },
  {
    path: '/admin/category',
    name: 'AddCategory',
    component: AddCategory,
  },
  {
    path: '/admin/category/:id',
    name: 'EditCategory',
    component: EditCategory,
  },
  {
    path: "/admin/product",
    name: "AdminProduct",
    component: Product,
  },
  {
    path: "/admin/product",
    name: "AddProduct",
    component: AddProduct,
  },
  {
    path: "/admin/product/:id",
    name: "EditProduct",
    component: EditProduct,
  },
  {
    path : '/product/:id',
    name : 'ShowDetails',
    component: ShowDetails,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
