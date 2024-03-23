<template>
    <div class="big">
        <Header title="审核新闻">

        </Header>



        <div class="s">
            <van-card 
v-for="item in dataList"
@click="todel(item.nid)"
class="custom-card"
:key="item.nid"
  :desc="item.dates"
  :title="item.title"
  :thumb="item.npic"
/>


        </div>
    </div>
</template>
<script>
import Header from '@/components/Header.vue';
import { onMounted } from 'vue';
// import { showToast } from 'vant';
import { ref } from 'vue';
import axios from 'axios';
import router from '@/router';
const instance = axios.create({
      baseURL: 'http://localhost:9090/new',
      timeout: 1000, 
    })
export default{
    components:{
   Header
    
   
},
setup(){
    const todel=(id)=>{
  router.push({ path: `/shendetil/${id}` });
}
    const dataList = ref([]);
    onMounted(() => {
    




      instance.get('/findno')
   .then(function(res){
  
    if(res.data.code==200){
     
console.log(res.data.data.info);
dataList.value=res.data.data.info;
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


dataList,todel


    }
}
}




</script>
<style lang="less" scoped>
.custom-card {
  border-bottom:0.2px solid #eee;
  background-color:  #fff; /* 设置背景颜色 */
 --van-card-padding: 2px;
  --van-card-thumb-size: 34px;
  
}



</style>