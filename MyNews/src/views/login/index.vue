<template>
    <div class="big">
        <div class="logo-container">
      <!-- 放置 Logo 的内容 -->
      <img src="@/assets/1.png" alt="Logo" class="tup"/>
    </div>
      <div  class="login-box">
        <van-form @submit="onSubmit">
          <van-cell-group inset>
            <van-field
              v-model="username"
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
          </van-cell-group>
          <div style="margin: 16px;">
            <van-button color="#1751f1" round block type="primary" native-type="submit" @click="onSubmit">
              登录
            </van-button>
            <div style="height: 20px;"></div> <!-- 添加间隔 -->
            <van-button color="#ffc400" round block type="primary" native-type="submit" @click="tozhuce">
              注册
            </van-button>
          </div>
        </van-form>
      </div>
    </div>
  </template>
  
  <script>
import { ref } from 'vue';
import axios from 'axios';
import 'vant/es/toast/style';
import {  showFailToast, showSuccessToast } from 'vant';
import { useRouter } from 'vue-router';

const instance = axios.create({
  baseURL: 'http://localhost:9090',
  timeout: 3000,
});

export default {
  setup() {
    let isLoggedIn = ref(false);
    let router = useRouter();
    let username = ref('');
    let password = ref('');
    const loginSuccess = () => {
      isLoggedIn.value = true;
      console.log('Login successful!');
    };
    let tozhuce = () => {
      router.push('/register');
    }
    let onSubmit = () => {
      instance
        .get('/login', {
          params: {
            account: username.value,
            password: password.value,
          },
        })
        .then(function (res) {
          if (res.data.code == 200) {
            showSuccessToast('登录成功');
            
          
            localStorage.setItem('userid', res.data.data.info.userid);
            localStorage.setItem('status', res.data.data.info.status);
            router.push('/setting');
          } 
          
          else if(res.data.code == 666){
            showFailToast('该账号已经被封禁，请找管理员申诉');
          }
          else {
           showFailToast('账号或者密码错误');
          }
        })
        .catch(function (error) {
             
              console.log(error);
});
    };

    return {
      username,
      password,
      onSubmit,
      isLoggedIn,
      tozhuce,
    };
  },
};
  </script>
  
  <style lang="less" scoped>
  .big {
    display: flex;
    flex-flow: column;
  
    .logo {
      display: flex;
      border-radius: 5px;
      background: linear-gradient(90deg, #ffc400, #f29658);
      margin: auto;
  background-color: #1751f1;
      width: 90%;
      height: 250px;
      span {
        margin: auto;
      }
    }
    .logo-container {
  text-align: center;
  height: 120px;
  margin-top: 20px;
  .tup{
    height: 90%;

width: 80%;
  }
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
    .login-box {
      margin-top: 4px;
    }
  }
  </style>