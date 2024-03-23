<template>
 <div >
  <van-tabbar v-model="active" class="foot" :class="{ 'hot-background': isHotItemClicked }">
    
     <van-tabbar-item  icon="wap-home-o" dot>首页</van-tabbar-item>
    
     <van-tabbar-item icon="todo-list-o" dot>消息</van-tabbar-item>
     <van-tabbar-item icon="manager-o" >我的</van-tabbar-item>
   </van-tabbar>
 </div>
   </template>
   <script>
   
   import { ref } from 'vue';
   import { watch , onMounted} from 'vue';
import { useRouter } from 'vue-router';
   export default {
   
     setup() {

      let router =useRouter();
    const active = ref(0);
    const isHotItemClicked = ref(false);


 

      // 还可以执行其他点击事件的逻辑
 

            //  checked.value=props.carData.map((item)=>item.cardid);

watch(active, (newVal) => {
      switch (newVal) {
        case 0:
        isHotItemClicked.value = false;
          // router.push('/home');
          break;
        case 1:
        isHotItemClicked.value = false;
          router.push('/daily');
          break;
          case 3:
          isHotItemClicked.value = false;
          router.push('/setting');
          break;
        
        
        
        }
        
    
        
        }
          
          )
          onMounted(() => {
      // 在组件渲染后延迟执行路由跳转
      switch (active.value) {
        case 0:
          router.push('/home');
          break;
        case 1:
          router.push('/hot');
          break;
        case 2:
          router.push('/daily');
          break;
        case 3:
          router.push('/setting');
          break;
      }
    });
           


    return { active,router ,isHotItemClicked};
     },
   
   }
   </script>
   
   <style lang="less">
 .foot{
  --van-tabbar-item-text-color:black;
 
  background: #fff;
  border-top:0.5px solid #eee;
}
.hot-background {
  border-top:0px  solid black !important ;
  background: black !important; /* 设置热点项点击后的背景颜色 */
  --van-tabbar-item-active-color:#fff;
    --van-tabbar-item-active-background:black;
    --van-tabbar-item-inactive-color:#fff;
   
    --van-tabbar-item-text-color: #b7b5b5;
}
   
   </style>