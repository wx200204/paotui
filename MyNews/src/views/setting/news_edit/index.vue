<template>

    <div class="big" style="font-size: 20px;">
      <Header title="发布新闻" >
         

        </Header >
     
      <!-- <div class="my" @click="bc">返回</div> -->
      <div class="div">
        <van-cell-group inset>
  <van-field v-model="value" label="标题" placeholder="请输入标题" />

  <van-cell   >
    <template #title>
    <span class="custom-title">封面</span>


    
  </template>
  <template #value>
    <van-uploader :before-read="beforeRead" v-model="fileList" multiple max-count="1" :result-type="file"/>

    
    
  </template>
  </van-cell>
</van-cell-group>



      </div>
        <div id="editorContainer"></div>

    </div>
</template>
<script>

import { useRouter } from 'vue-router';
import { SpEditor } from 'sp-editor';
import 'sp-editor/css'
import { ref} from 'vue';
import { onMounted } from 'vue';
import axios from 'axios';
import Header from '@/components/Header.vue';
import {  showFailToast, showSuccessToast } from 'vant';
const instance = axios.create({
      baseURL: 'http://localhost:9090/new',
      timeout: 3000, 
    })
export default{
    components:{ 
      Header
},
setup(){
  const value = ref('');
  let myid=1;
  let router=useRouter();
  const editorContent = ref('');
let spEditor; 
const formData = new FormData();
  const beforeRead = (file) => {
      formData.append('photo', file);
      return true;
    };
    const fileList = ref([
     
     ]);
onMounted(() => {



 spEditor = new SpEditor({
  paragraphTailSpacing:'3',
      container: '#editorContainer',
      toolbarButtons: ['choose-picture', 'text-style','1','2','3','4','5'],
    });
    spEditor.addToolbarButton({
  name: 'custom-button-name',
  className: 'custom-button-class', // 添加自定义类名
    innerHtml: '提交', // 添加按钮内部内容
    style: {
      backgroundColor: '#3498db',
      color: '#fff',
      padding: '5px 10px',
      borderRadius: '5px',
    },
})


spEditor.on('toolbarButtonOnClick', (name) => {
  if (name === 'custom-button-name') {
    console.log(spEditor.getHtml())
    formData.append('userid', localStorage.getItem('userid'));
    formData.append('title', value.value);
    formData.append('content',spEditor.getHtml());

    instance.post('/insert',formData, {
      
           headers: {
            "Content-Type": "multipart/form-data",
          },

})
.then(response => {
  showSuccessToast('操作成功，请耐心等待审核');
  router.back();
  // 处理成功响应
  console.log(response.data);
})
.catch(error => {
  // 处理错误
  console.error('Error:', error);
});


    // do something ...
  }
})


    
  });



      







    const bc = () => {
   router.back();
      
    }



    return {beforeRead,
      spEditor,value,
bc,myid,
editorContent,router,fileList,formData
    };



}
}




</script>
<style lang="less" scoped>

.my{
  margin-left: 7px;
}

#editorContainer{
  border-radius: 5px;
  background: #fff;
  margin: 4px;
  padding: 2px;

}
</style>