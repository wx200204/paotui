<template>
    <div class="big">
        <van-pull-refresh v-model="loading" @refresh="onRefresh" head-height="50" style="min-height: 100vh;" pull-distance="5">
            <van-tabs v-model:active="activeName" :swipeable="true" sticky animated >
  <van-tab name="a">
    <template #title>
      <div class="custom-tab-title">
        <span>评论</span>
      
      </div>
    </template>
    <van-empty description="暂无评论" />
  </van-tab>
  <van-tab name="b">
    <template #title>
      <div class="custom-tab-title">
        <span>点赞</span>

      </div>
    </template>
    <van-empty description="暂无点赞" />
  </van-tab>
  <van-tab name="c">
    <template #title>
      <div class="custom-tab-title">
        <span>系统通知</span>
        <van-icon name="bell-o" />
      </div>
    </template>
    <van-empty description="暂无通知" />
  </van-tab>
</van-tabs>


</van-pull-refresh>

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