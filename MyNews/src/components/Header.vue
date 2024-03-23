<template>
    <div class="header">
      <van-icon name="arrow-left" class="icon" @click="tohome"/>
      <div>
          {{ title }}
      </div>
    </div>
  </template>
  <script>
  import { useRouter } from 'vue-router';
  export default{
      props:['title'],
      setup(){
          let router=useRouter();
          let tohome=()=>{
              router.back();
          }
          return{
          tohome
      }
  
      }
  }
  
  
  
  </script>
  <style lang="less" scoped>
  .header {
    background-color: #fff;
    height: 10px;
    font-size: 6px;
    display: flex;
    justify-content: center;
    align-items: center;
    border-bottom: 1px solid #d7d7d7;
    .edit {
      font-size: 16px;
      position: absolute;
      right: 15px;
      font-weight: normal;
    }
    .icon {
      position: absolute;
      left: 10px;
    }
  }
  
  
  
  </style>