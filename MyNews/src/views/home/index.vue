<template>
    
    <div class="big">
      <div class="xuanfu">
    <div class ="search">
        <van-search
  v-model="value"
  show-action
  placeholder="请输入搜索关键词"
  class="custom-search"
  @search="onSearch"
>
<!-- 
 <template #left>
    <div style="font-size: 16px; margin-right: 1px;" >首页</div>
  </template>  -->

  <template #action>
    <div @click="onClickButton" class="soushuo">搜索</div>
  </template>
</van-search>


</div>
        
    <div class="header">


        <van-tabs v-model:active="active"  @click-tab="onClickTab" sticky :offset-top="51">
  <van-tab  div="gd1" title="推荐">
    <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white" lazy-render>
    <van-swipe-item v-for="image in images" :key="image" class="image-item">
  <img :src="image" class="image" />
</van-swipe-item>

</van-swipe>
<van-card 
v-for="item in dataList"
@click="todel(item.nid)"
class="custom-card"
:key="item.nid"
  :desc="item.dates"
  :title="item.title"
  :thumb="item.npic"
/>





</van-tab>

  <van-tab    title="抢单">内容 2</van-tab>
  <van-tab  title="代取">内容 3</van-tab>
  <van-tab   title="代送">内容 4</van-tab>

</van-tabs>


        
   
       
  </div> 
</div>

>
    </div>
</template>
<script>
import { onMounted } from 'vue';
import { showToast } from 'vant';
import { ref } from 'vue';
import axios from 'axios';
import router from '@/router';
const instance = axios.create({
      baseURL: 'http://localhost:9090/new',
      timeout: 1000, 
    })
export default {
  components:{



},
  setup() {


const todel=(id)=>{
  router.push({ path: `/ndel/${id}` });
}



    onMounted(() => {
    




      instance.get('/home')
   .then(function(res){
  
    if(res.data.code==200){
     
console.log(res.data.data.info);
dataList.value=res.data.data.info;
    }
 
 
 
 
    else{
 
   console.log("sb");
    }
 
   })
   .catch(function (error) {

     console.log(error);
   });














    })
    const images = [
      'https://fastly.jsdelivr.net/npm/@vant/assets/apple-1.jpeg',
      'https://fastly.jsdelivr.net/npm/@vant/assets/apple-2.jpeg',
    ];
    const dataList = ref([]);
    const active = ref(0);
    const activeName = ref('a');
    const value = ref('');
    const onSearch = (val) => showToast(val);
    const onClickTab = ({ title }) => showToast(title);
    const onClickButton = () => showToast(value.value);
    return {
      value,
      onClickTab,
      images,
      activeName,
      active,
      onSearch,
      onClickButton,dataList,todel
    };
  },
};








</script>
<style lang="less" scoped >
.big{
  height: 500px; /* 设置 div 的高度，可根据需要调整 */
  background-color: #fff; /* 可选：设置背景颜色 */
  display: flex; /* 使用 Flexbox 布局 */
  flex-direction: column; /* 垂直方向排列内容 */
 
  


.header{
  margin-top: 18px;
    height: 15px;
    border-radius: 1.5px;
    
 
}



}

.my-swipe .van-swipe-item {
    color: #fff;
    font-size: 20px;
    line-height: 125px;
    text-align: center;

   
    background-color: #f9f5f5;
  }
  .image-item {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%; /* 使图片垂直居中 */
}

.image {
  max-width: 60%; /* 图片最大宽度为容器宽度 */
  max-height: 80%; /* 图片最大高度为容器高度 */
  object-fit: contain; /* 根据容器的宽高比例自动调整图片尺寸 */
}

.custom-card {
  border-bottom:0.2px solid #eee;
  background-color:  #fff; /* 设置背景颜色 */
 --van-card-padding: 2px;
  --van-card-thumb-size: 34px;
  
}
.custom-search {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 100; /* 设置一个合适的z-index，确保它在最上层 */
  background-color: #fff; /* 可以根据需要设置背景颜色 */
  display: flex; /* 让左侧和右侧内容水平排列 */
  justify-content: space-between; /* 左右两侧内容分散对齐 */
  align-items: center; /* 垂直居中 */
  padding: 5px;
 
  
  --van-search-input-height: 10px; /* 设置输入框的高度 */
  --van-search-label-font-size: var(--van-font-size-lg); /* 设置 label 字体大小 */
  
  --van-search-action-padding: 0 0px; /* 设置右侧按钮内边距 */
  --van-search-action-font-size: var(--van-font-size-lg); /* 设置右侧按钮字体大小 */

  .soushuo{

margin-left: 4px;
  }
}
.gd1{
position: fixed;

}

</style>