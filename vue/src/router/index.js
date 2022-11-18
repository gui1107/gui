import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: '登录',
    component: () => import("../components/Login")
  },
  {
    path: "/register",
    name: "注册",
    component: () => import("../components/Register")
  },
  {
    path: "/",
    name: "主页管理",
    component: () => import("../components/Manage"),
    redirect: "/Home",
    children: [
      {
        path: "Home",
        name: "主页",
        component: () => import("../components/Home")
      },
      {
        path: "test",
        name: "test",
        component: () => import("../components/ruletest")
      }
    ]
  },
  {
    path: "/t",
    component: () => import("../components/test")
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
