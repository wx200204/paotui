<template>
    <div class="big">
      <div class="logo-container">
        <!-- Place your Logo content here -->
        <img src="@/assets/1.png" alt="Logo" />
      </div>
      <div class="register-box">
        <van-form @submit="onSubmit">
          <van-cell-group inset>
            <van-field
              v-model="account"
              name="账号"
              label="账号"
              placeholder="账号"
              :rules="[{ required: true, message: '请填写账号' }]"
            />
            <van-field
              v-model="password"
              type="password"
              name="密码"
              label="密码"
              placeholder="密码"
              :rules="[{ required: true, message: '请填写密码' }]"
            />
            <van-field
  v-model="confirmPassword"
  type="password"
  name="确认密码"
  label="确认密码"
  placeholder="确认密码"
  :rules="[
    { required: true, message: '请确认密码' },
    { validator: validateConfirmPassword }
  ]"
/>
          </van-cell-group>
         
          <div style="margin: 16px;">
            <van-button color="#ffc400" round block type="primary" native-type="submit" @click="onSubmit">
              注册
            </van-button>
          </div>

          <div style="text-align: center;">
    <router-link to="/forgot-password" class="small-link">忘记密码？</router-link>
  </div>
        </van-form>
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  import axios from 'axios';
  import 'vant/es/toast/style';

  import { useRouter } from 'vue-router';
  import {  showFailToast, showSuccessToast } from 'vant';
  const instance = axios.create({
  baseURL: 'http://localhost:9090',
  timeout: 3000,
});

export default {
  setup() {
    let router = useRouter();
    let account = ref('');
    let status = ref('');
    let password = ref('');
    let confirmPassword = ref('');
    const selectedStatus = ref('');
  
  
    const validateConfirmPassword = (rule, value, callback) => {
      if (value !== password.value) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    


   


  

    let onSubmit = () => {
      instance
        .get('/register', {
          params: {
            account: account.value,
            password: password.value,
          
          },
        })
        .then(function (res) {
          if (res.data.code === "200") {
            showSuccessToast('注册成功');
            router.push('/login');
          } else if (res.data.code === "301") {
            showFailToast('账号已存在，请重试');
          }else if (res.data.code === "900") {
            showFailToast('注册失败，请重试');}

        })
        .catch((error) => {
          console.log(error);
          showFailToast('注册失败，请重试');
        });
    };

    return {
      account,
      password,
      confirmPassword,
      onSubmit,
      selectedStatus,
      validateConfirmPassword,
     
     
      
     
     status,
      
    };
  },
};
</script>
  
  <style lang="less" scoped>
  .big {
    display: flex;
    flex-flow: column;
  
    .logo-container {
      text-align: center;
      margin-top: 20px;
    }
    .small-link {
    font-size: smaller;
    text-decoration: underline;
  }
    .logo {
      border-radius: 5px;
      background: linear-gradient(90deg, #ffc400, #f29658);
      width: 90%;
      height: 250px;
      margin: auto;
      display: flex;
      justify-content: center;
      align-items: center;
  
      img {
        max-width: 100%;
        max-height: 100%;
      }
    }
  
    .register-box {
      margin-top: 10px;
    }
  }
  </style>