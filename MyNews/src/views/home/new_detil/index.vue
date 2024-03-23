<template>
    <div class="big">
       

<Header title="新闻">

</Header>
        <div class="biaoti">

标题： {{ biao }}
        </div>
        <div class="qi">

  日期：{{ ri }}
        </div>
    <div class="new" v-html="richTextData">
    
    
    </div>
    </div>
</template>

<script>
import { onMounted,ref } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';
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
    const  ri = ref('');
    let route =useRoute();
let id=ref('');

    onMounted(  () => {
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
ri.value=res.data.data.info.dates;
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
route,id,richTextData,biao,ri
    }
}
}



</script>
<style lang="less" scoped>

.new{
    margin-top: 1px;
    background: #fff;
    font-size: 6px
}
.biaoti{
    background: #fff;
    font-size: 8px;
    font-weight:bold;
}
.qi{
    background: #fff;
    font-size: 5px;
    font-weight:bold; 
}
::v-deep img{
     max-width:100%;
 }

</style>