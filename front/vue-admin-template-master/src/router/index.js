import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },

  {
    path: '/teacher',
    component: Layout,
    redirect: '/teacher/table',
    name: '讲师管理',
    meta: { title: '讲师管理', icon: 'example' },
    children: [
      {
        path: 'list',
        name: '讲师列表',
        component: () => import('@/views/edu/teacher/list'),
        meta: { title: '讲师列表', icon: 'list' }
      },
      {
        path: 'saveOrUpdate',
        name: '添加讲师',
        component: () => import('@/views/edu/teacher/save'),
        meta: { title: '添加讲师', icon: 'tree' }
      },
      {
        //这个地方相当于sql的where条件，进入这个路由的时候传递一个参数
        path: 'edit/:id',   
        name: 'EduTeacherEdit',
        component: () => import('@/views/edu/teacher/save'),
        meta: { title: '编辑讲师', noCache: true },
        //表示隐藏在侧边栏，其实只是添加了一个路由，但是这个框架会让新加的路由增加在侧边栏
        //但是有不想显示在侧边栏，所以就用这个属性hidden
        hidden: true
      }
    ]
  },

  {
    path: '/subject',
    component: Layout,
    redirect: '/subject/list',
    name: '课程分类管理',
    meta: { title: 'subject', icon: 'subject' },
    children: [
      {
        path: 'list',
        name: '课程分类列表',
        component: () => import('@/views/edu/subject/list'),
        meta: { title: '课程分类列表', icon: 'list' }
      },
      {
        path: 'insert',
        name: '添加课程分类',
        component: () => import('@/views/edu/subject/insert'),
        meta: { title: '添加课程分类', icon: 'add' }
      }
    ]
  },

  {
    path: '/course',
    component: Layout,
    redirect: '/course/list',
    name: '课程管理',
    meta: { title: 'course', icon: 'submanagement' },
    children: [
      {
        path: 'list',
        name: '课程列表',
        component: () => import('@/views/edu/course/list'),
        meta: { title: '课程列表', icon: 'list' }
      },
      {
        path: 'info',
        name: '添加课程',
        component: () => import('@/views/edu/course/info'), 
        meta: { title: '添加课程', icon: 'info' },
      },
      {
        path: 'chapter',
        name: '添加章节',
        component: () => import('@/views/edu/course/chapter'), 
        meta: { title: '添加章节', icon: 'info' },
        hidden: true
      },
      {
        path: 'publish',
        name: '发布课程',
        component: () => import('@/views/edu/course/publish'), 
        meta: { title: '发布课程', icon: 'info' },
        hidden: true
      },
      {
        path: 'info',
        name: '添加课程',
        component: () => import('@/views/edu/course/info'), 
        meta: { title: '添加课程', icon: 'info' },
        hidden: true
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://panjiachen.github.io/vue-element-admin-site/#/',
        meta: { title: 'External Link', icon: 'link' }
      }
    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
