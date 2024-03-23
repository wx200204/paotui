<template>
    <div class="big">
       

<Header title="查看审核新闻">

</Header>
        <div class="biaoti">

{{ biao }}





        </div>
    <div class="new" v-html="richTextData">
    
    
    </div>
    <div class="shenbutton">
        <van-button type="danger" @click="shenbt">审核不予通过</van-button>
        <van-button type="success" @click="shentg">审核通过</van-button>
    </div>
    </div>
</template>

<script>
import router from '@/router';
import { onMounted,ref } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';
import {  showFailToast, showSuccessToast } from 'vant';
import Header from '@/components/Header.vue';
const instance = axios.create({
      baseURL: 'http://localhost:9090/new',
      timeout: 1000, 
    })
export default{
    components:{
   
    Header
   
},

setup(){
    const richTextData = ref('');
    const  biao = ref('');
    let route =useRoute();
let id=ref('');


const shentg=()=>{
    instance.get('/upsuccess',{
    params: {
      nid:id.value

    }
  }
         )
   .then(function(res){
  
    if(res.data.code==200){
      showSuccessToast('操作成功');
console.log(res.data.data.info);

    }
 
 
 
 
    else{
 
   console.log("sb");
    }
 
   })
   .catch(function (error) {

     console.log(error);
   });




}
const shenbt=()=>{
    instance.get('/upfail',{
    params: {
      nid:id.value

    }
  }
         )
   .then(function(res){
  
    if(res.data.code==200){
      showSuccessToast('操作成功');
      router.back();
console.log(res.data.data.info);

    }
 
 
 
 
    else{
 
   console.log("sb");
    }
 
   })
   .catch(function (error) {

     console.log(error);
   });




}







    onMounted(() => {
         id.value =route.params.id;
        

         instance.get('/find',{
    params: {
      nid:id.value
    }
  }
         )
   .then(function(res){
  
    if(res.data.code==200){
     
console.log(res.data.data.info);
richTextData.value=res.data.data.info.content;
biao.value=res.data.data.info.title;

    }
 
 
 
 
    else{
 
   console.log("sb");
    }
 
   })
   .catch(function (error) {

     console.log(error);
   });





    })





    return{
route,id,richTextData,biao,shenbt,shentg
    }
}
}



</script>
<style lang="less" scoped>

.new{

    background: #fff;
    font-size: 6px
}
.biaoti{
    background: #fff;
    font-size: 8px;
    font-weight:bold;
}
::v-deep img{
     max-width:100%;
 }

</style>