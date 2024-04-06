<template>

    <div class="big" style="font-size: 20px;">
      <div class="big2">

     
      <div class="info" @click="editUserInfo">
        <div class="info-content">
      <van-card class="custom-card" desc="用户昵称" :title="nick">
        <template #thumb>
          <van-icon
            name="https://fastly.jsdelivr.net/npm/@vant/assets/icon-demo.png"
            class="large-icon"
          />
        </template>
      </van-card>
    </div>
    <div class="arrow-icon">
      <van-icon name="arrow" />
    </div>
</div>


<div class="middle">


  <div class="child-div">
    <van-icon name="like-o" size="30"/>
    <span>
      喜欢
    </span>
  </div>

  <div class="child-div">
    <van-icon name="label-o" size="30"/>
    <span>
      关注
    </span>
  </div>

  <div class="child-div">
    <van-icon name="star-o" size="30"/>
    <span>
      收藏
    </span>
  </div>
  
  <div class="child-div">  <van-icon name="underway-o" size="30"/>
    <span>
      历史
    </span>
  </div>

</div>

</div>
<div class="biao">
  <div class="box" @click="Fabu">
    <van-icon name="guide-o"        size="30px"/>
    <span class="zuo">发布订单</span>
    <van-icon name="arrow" size="25px"/>
  </div>

  <div class="box" @click="toadvice">
    <van-icon name="newspaper-o" size="30px"/>
    <span class="zuo">意见反馈</span>
    <van-icon name="arrow" size="25px"/>
  </div>

  <div class="box" @click="Shen">
    <van-icon name="sign"   size="30px"/>
    <span class="zuo">审核订单</span>
    <van-icon name="arrow" size="25px"/>
  </div>

  
  <div class="box" @click="tolookadvice">
    <van-icon name="newspaper-o" size="30px"/>
    <span class="zuo">查看意见反馈</span>
    <van-icon name="arrow" size="25px"/>
  </div>


  <div class="box">
    <van-icon name="bulb-o"   size="30px"/>
    <span class="zuo">账号管理</span>
    <van-icon name="arrow" size="25px"/>
  </div>  
  <div class="box" @click="Tui" v-show="dstatus">
    <van-icon name="revoke"   size="30px"/>
    <span class="zuo">退出登录</span>
    <van-icon name="arrow" size="25px"/>
  </div>  
  <div class="box" v-show="!dstatus" @click="tologin">
    <van-icon name="user-o"   size="30px"/>
    <span class="zuo">去登录</span>
    <van-icon name="arrow" size="25px"/>
  </div>  


</div>



   

    <!-- <div class="fa" @click="Fabu">发布新闻</div>
    <div class="shen" @click="Shen">审核新闻</div>
    <div class="tui" @click="Tui"> 退出登录</div>
    <div class="tui" > 登录</div>
    <div class="tui"> 账号管理 </div> -->

    <!-- <div v-html="richTextData">
    
    
    </div> -->

    </div>
</template>
<script>

import { useRouter } from 'vue-router';
import { ref } from 'vue';
import {  showFailToast } from 'vant';
import { onMounted } from 'vue';
import { addNumber } from 'vant/lib/utils';



export default{
    components:{ 
  
},
setup(){
  const dstatus=ref(true);
  const richTextData = ref('');
  const editUserInfo = () => {
    router.push('/gai')
    };

    const nick=ref('');
    const tologin=()=>{
      router.push('/login')

    }



    onMounted(() => {
   if(localStorage.getItem('status')!=null){
      if(localStorage.getItem('status')==2){
        nick.value="媒体用户"
      }
      else if(localStorage.getItem('status')==3){
        nick.value="管理员用户"
      }
      else{
        nick.value="普通用户"
      }

    }
    else{
      dstatus.value=false
    }

      



    })












  let router=useRouter();
  let Fabu = () => {
    if( (localStorage.getItem('status')>=2)||(localStorage.getItem('status')==null)){
      router.push('/fa')
      
    }
    else{
      showFailToast('您无权限操作');
    }
   
  

  }
  let toadvice = () => {
    router.push('/advice')

  }



  let tolookadvice = () => {
    if( localStorage.getItem('status')==3){
      router.push('/lookadvice')   
    }
    else{
      showFailToast('您无权限操作');
    }
  }







  let Shen = () => {

    if( localStorage.getItem('status')==3){
      router.push('/shen')     
    }
    else{
      showFailToast('您无权限操作');
    }
  }


  let Tui = () => {
    localStorage.removeItem('userid');
    localStorage.removeItem('status');
    router.push('/login')
  }
  return{
   
   
      richTextData,
      editUserInfo,
    router,Fabu,Shen,Tui,nick,toadvice,tolookadvice
  ,dstatus,tologin
  }



}
}




</script>
<style lang="less" scoped>
.big{
  
  --van-card-padding:8px;
  --van-card-font-size:6px;
  --van-card-title-line-height:10px;
 
}
.big2{
  --van-card-background:linear-gradient(to bottom, #93c1f0, transparent);
  background: linear-gradient(to bottom, #93c1f0, transparent);
}
 .large-icon {
    font-size: 24px; /* 调整图标的大小，这里设置为 24px，根据需要调整 */
  }

  .info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  
}

.info-content {
  flex: 1; /* 这个部分占据剩余的空间 */
}

.arrow-icon {
  /* 可以在这里添加样式来设置箭头图标的样式 */
  background: linear-gradient(to bottom, #93c1f0, transparent);
  padding: 18px; 
}
.middle {
  margin-left: 8px;
  margin-right: 8px;
  width: 80%;
    display: flex;
    justify-content: space-between; /* 或者使用 justify-content: space-around; */

    .child-div {

      display: flex;
    flex-direction: column;
    align-items: center; /* 居中对齐，可根据需要调整 */
    text-align: center; 
    
  }
  }


  .biao {
    display: flex;
    flex-direction: column; /* 设置为列方向，实现竖直排列 */
    align-items: center; /* 可选，使盒子在垂直方向居中 */
    margin-top: 10px;  
  }
  .box {
    display: flex; /* 使用 Flexbox 布局 */
    align-items: center; /* 使图标和文字在垂直方向上居中对齐 */
    width: 98px; /* 设置盒子的宽度，根据需要调整 */
    height: 10px; /* 设置盒子的高度，根据需要调整 */
    margin-bottom: 8px; /* 设置盒子之间的垂直间距，根据需要调整 */
    background-color:transparent; /* 设置盒子的背景颜色，根据需要调整 */
    margin-right: 25px;
    margin-left: 18px;
  }
  .box van-icon {
    margin-right: 50px; /* 使用 !important 增加优先级 */
  }
  .box span {
    flex: 1; /* 让文字占据剩余的空间，实现竖直居中 */
  }
.zuo{
  margin-left: 8px;
}
</style>