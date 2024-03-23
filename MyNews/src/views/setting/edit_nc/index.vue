<template>
<div class="big" style="font-size: 20px;">
    <van-nav-bar
      title=" 修改昵称"
      left-text="返回"
      right-text="保存"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
    />
    <div style="height: 20px;"></div> <!-- 添加间隔 -->

    <van-cell-group inset>
  <van-field
    v-model="message"
    rows="1"
    autosize
    label="昵称"
    type="textarea"
    maxlength="10"
    placeholder="请输入昵称"
    show-word-limit
  />
</van-cell-group>






</div>    
    </template>
    <script>
    import { useRouter } from 'vue-router';
export default{
    components:{
   
    
   
},
setup(){
  let router = useRouter();
    const onClickLeft = () => {  router.back();}
    return {
      onClickLeft,

    };

   



}
}








    </script>
    <style lang="less" scoped>
  .big{
    --van-nav-bar-height:20px;
    
    
}
    
    </style>