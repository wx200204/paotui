<template>
  <div class="big" style="font-size: 20px;">
    <Header title="建议反馈"></Header>
    <van-cell-group>
      <van-field
        v-model="value"
        label="留言"
        type="textarea"
        placeholder="请输入留言,150字内"
        autosize
        border="{{ false }}"
      />
    </van-cell-group>
    <van-button class="submit-button" color="#1751f1" @click="tj">提交</van-button>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';
import Header from '@/components/Header.vue';
import { Toast } from 'vant'; // Import Toast from vant

const instance = axios.create({
  baseURL: 'http://localhost:9090/sug',
  timeout: 3000,
});

export default {
  components: {
    Header
  },
  setup() {
    const value = ref('');

    const tj = () => {
      instance
        .post('/insert', {
          suggestion: value.value,
        })
        .then(function (res) {
          if (res.data.code === 200) {
            Toast.success('提交成功');            
            // 返回上一级
            router.go(-1);
          } else {
            Toast.fail('提交失败');
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    };

    return {
      value,
      tj,
    };
  },
};
</script>

<style lang="less" scoped>
  .submit-button {
    margin-left: auto;
    display: block; 
  }
</style>
