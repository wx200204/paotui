import {createRouter,createWebHashHistory} from 'vue-router'
const router =createRouter({
history:createWebHashHistory(),
routes:[
    {
        path:'/',
        component:()=>import('../views/home')
    },
{
    path:'/home',
    component:()=>import('../views/home')
},
{
    path:'/hot',
    component:()=>import('../views/hot')
},
{
    path:'/daily',
    component:()=>import('../views/daily')
},
{
    path:'/setting',
    component:()=>import('../views/setting')
},


{
    path:'/login',
    component:()=>import('../views/login'),
    meta:{
        
        showNav:true
    }


},
{
    path:'/fa',
    component:()=>import('../views/setting/news_edit')

},
{
    path:'/gai',
    component:()=>import('../views/setting/info_edit')

},
{
    path:'/ndel/:id',

    component:()=>import('../views/home/new_detil')

},
{
    path:'/gai-nc',
    component:()=>import('../views/setting/edit_nc')

},{
    path:'/shen',

    component:()=>import('../views/setting/shen_edit')

},
{
    path:'/shendetil/:id',

    component:()=>import('../views/setting/shen_edit/shen_detil'),
    meta:{
        
        showNav:true
    }
},{
    path:'/advice',

    component:()=>import('../views/setting/advice_edit')

},
{
    path:'/lookadvice',

    component:()=>import('../views/setting/look_advice_edit')

},
{
    path: '/adviceDetail/:id',
    name: 'adviceDetail',
    component:()=>import('../views/setting/adviceDetail')
}

]

})
export default router