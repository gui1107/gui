import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: '��¼',
    component: () => import("../components/Login")
  },
  {
    path: "/register",
    name: "ע��",
    component: () => import("../components/Register")
  },
  {
    path: "/",
    name: "��ҳ����",
    component: () => import("../components/Manage"),
    redirect: "/Home",
    children: [
      {
        path: "Home",
        name: "��ҳ",
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
