<template>
    <div class="big">
      <van-tabs v-model:active="active" @click-tab="onClickTab">
  <van-tab title="我寄的">
    
    <van-tabs v-model:active="active"  @click-tab="onClickTab" sticky :offset-top="51">
  <van-tab  div="gd1" title="全部">内容 1
   
</van-tab>

  <van-tab    title="待支付">内容 2</van-tab>
  <van-tab  title="进行中">内容 3</van-tab>
  <van-tab   title="已完成">内容 4</van-tab>

</van-tabs>

  </van-tab>



  <van-tab title="我收的">    <van-tabs v-model:active="active"  @click-tab="onClickTab" sticky :offset-top="51">
  <van-tab  div="gd1" title="全部">内容 1
   
</van-tab>

  <van-tab    title="待支付">内容 2</van-tab>
  <van-tab  title="进行中">内容 3</van-tab>
  <van-tab   title="已完成">内容 4</van-tab>

</van-tabs></van-tab>
</van-tabs>

    </div>
</template>
<script>
import { showToast } from 'vant';
import { ref } from 'vue';


export default{
  components:{
    
  
 },
setup(){
    
    const activeName = ref('a');
    const loading = ref(false);
    const onRefresh = () => {
      setTimeout(() => {
        showToast('刷新成功');
        loading.value = false;
       
      }, 1000);
    };

    return{
        activeName,
      loading,
      onRefresh, 
    }
}
}




</script>
<style lang="less" scoped>
.big {
    
  height: 100vh; /* 设置高度为视口高度，充满整个屏幕 */
  position: absolute;
  width: 100%;
  height: 100%;
  overflow: hidden;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  --van-tabs-card-height:50px;
  --van-tab-font-size:6px;
  --van-empty-image-size:100%;
  --van-tabs-line-height: 20px;



}

.van-pull-refresh {
  position: absolute;
  width: 100%;
  height: 100%;
  overflow-y: auto;
}

</style>