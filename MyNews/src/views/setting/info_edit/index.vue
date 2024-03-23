<template>

  <div class="big" style="font-size: 20px;">
      <van-nav-bar
        title="个人资料"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
      />
      <div style="height: 20px;"></div> <!-- 添加间隔 -->
      <van-cell is-link @click="show = true">
      <template #title>
        头像
      </template>
      <van-icon name="https://fastly.jsdelivr.net/npm/@vant/assets/icon-demo.png" class="info_icon" />
      <template #right>
        
        <van-icon name="arrow" />
      </template>
  
    </van-cell>
    <van-cell is-link @click="editUsernc">
      <template #title>
          用户名
      </template>
    
      <template #right>
        <van-icon name="arrow" />
      </template>
    </van-cell>
    <van-field
    v-model="value"
    is-link
    readonly
    label="城市"
    placeholder="选择城市"
    @click="showPicker = true"
  />
  <van-popup v-model:show="showPicker" round position="bottom">
    <van-picker
      :columns="columns"
      @cancel="showPicker = false"
      @confirm="onConfirm"
    />
  </van-popup>
  
    <van-action-sheet
        v-model:show="show"
        :actions="actions"
        cancel-text="取消"
        close-on-click-action
        @cancel="onCancel"
      />
  
      
    </div>
  </template>
  <script>
  import { ref } from 'vue';
  import { showToast } from 'vant';
  import { useRouter } from 'vue-router';
  
  
  export default{
      components:{
     
      
     
  },
  setup(){
    const columns = ['杭州', '宁波', '温州', '绍兴', '湖州', '嘉兴', '金华'];
      const result = ref('');
      const showPicker = ref(false);
  
      const onConfirm = (value) => {
        result.value = value;
        showPicker.value = false;
      };
  
      // 在这里定义 value，并初始化为一个默认值，或者根据你的实际需求进行初始化
      const value = ref(''); 
  
      let router=useRouter();
      const afterRead = (file) => {
        // 此时可以自行将文件上传至服务器
        console.log(file);
      };
      let editUsernc = () => {
      router.push('/gai-nc')
  
    }
      const show = ref(false);
      const actions = [
        { name: '上传图片' },
        
      ];
      
      const onCancel = () => {
        showToast('取消');
        show.value = false; // 关闭底部弹窗
      };
      const onClickLeft = () => {
        router.back();
      }
      return {
        onClickLeft,
        show,
        actions,
        onCancel,
        afterRead,
        editUsernc,
        result,
        columns,
        onConfirm,
        showPicker,
        value,
      };
  
     
  
  
  
  }
  }
  
  
  
  
  </script>
  <style lang="less" scoped>
  .big{
      --van-nav-bar-height:20px;
      --van-cell-line-height:15px;
      
  }
  
  .info_icon{
      font-size: 12px;
      
  
  }
  
  </style>