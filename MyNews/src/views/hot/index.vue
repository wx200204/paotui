<template>
    <div class="big"  @touchstart="onTouchStart" @touchmove="onTouchMove"
    >
  
    <van-barrage v-model="list" 
    :top="120"
    :duration="5000"
    style="width: 100%; height: 95%;"
    >
    <video
    :key="currentVideoIndex"
    controls="false"
    controlslist="nodownload nofullscreen noremoteplayback"
    disablePictureInPicture="true"
    autoplay="true"
    style="width: 100%; height: 100%;">
    <source :src="videos[currentVideoIndex]" type="video/mp4" />

    </video>
  </van-barrage>




    <div class="video-controls" >
        <van-icon name="like" :color="iconColor" class="control-icon"  @click="changeIconColor" />
        <van-icon name="chat" color="#fff"  class="control-icon" @click="showPopup"/>
        <van-icon name="star" :color="iconColor2"  class="control-icon" @click="changeIconColor2" />
        <van-icon name="share" color="#fff"  class="control-icon" @click="showShare = true" />
        <van-share-sheet
  v-model:show="showShare"
  title="立即分享给好友"
  :options="options"
  @select="onSelect"
/>
     
  </div>
  <van-popup
  v-model:show="show"
  position="bottom"
  round
  :style="{ height: '60%' }"

>
<div class="tanchu">



<van-cell-group>

<span class="mpin">
  评论
</span>

<div v-for="com in comment" :key="com.cid" class="zplun">
  <van-cell  >
  <!-- 使用 title 插槽来自定义标题 -->
  <template #title>
    <div class="mytu">
      <van-image
  round
  width="0.8rem"
  height="0.8rem"
  src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
  class="my_image"
/>
<div class="nic">
  <span class="myni">
  {{ com.nickname }}
</span>
<span class="mypin">
  {{ com.comment }}
</span>

</div>
 
</div>
  </template>

  <template #value>
    <div class="kong">

    </div>
    <div class="myvalue">
      <!-- <span style="color:black">
回复
</span> -->
<div class="huifu" style="color:black">
  回复
</div>


<div class="divaishu">
  <van-icon name="like-o" size="16" />
  <span class="number" style="vertical-align: bottom;">{{ com.likes }}</span> 
</div>
 
  



      
    </div>
   
  </template>

</van-cell>
<!-- 二级评论 -->
<div v-for="subComment in com.son" :key="subComment.cid">
  <van-cell  >
  <!-- 使用 title 插槽来自定义标题 -->
  <template #title>
    <div class="mytu">
      <van-image
  round
  width="0.8rem"
  height="0.8rem"
  src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
  class="my_image"
/>
<div class="nic">
  <span class="myni">
  {{ subComment.nickname }}
</span>
<span class="mypin">
 回复{{ com.nickname }}:{{ subComment.comment }}
</span>

</div>
 
</div>
  </template>

  <template #value>
    <div class="kong">

    </div>
    <div class="myvalue">
      <!-- <span style="color:black">
回复
</span> -->



<div class="divaishu">
  <van-icon name="like-o" size="16" />
  <span class="number" style="vertical-align: bottom;">{{ subComment.likes }}</span> 
</div>
 
  



      
    </div>
   
  </template>

</van-cell>



</div>
<!-- 二级评论 -->

</div>






</van-cell-group>
<div class="huifuz">

  <van-field
    placeholder="请输入评论内容"
  >
    <template #button>
      <van-button size="small" type="primary">评论</van-button>
    </template>
  </van-field>




</div>


</div>
</van-popup>
   

    </div>
</template>
<script>

import { ref} from 'vue';
import { showToast } from 'vant';
import axios from 'axios';
import { onMounted } from 'vue';
const instance = axios.create({
      baseURL: 'http://localhost:9090',
      timeout: 3000, 
    })


let startY = 0;
export default{
    components:{

    
   
},
setup(){
  let comment=ref([]);
  onMounted(() => {
    instance.get('/comment', {
     params: {
       nid:1,
       
 
     }
   })
   .then(function(res){
  
    if(res.data.code==200){
     
console.log(res.data.data.info);
comment.value=res.data.data.info;
    }
 
 
 
 
    else{
 
   console.log("sb");
    }
 
   })
   .catch(function (error) {

     console.log(error);
   });



    
  });
  const originalColor = '#fff';
  const iconColor = ref('#fff');
  const iconColor2 = ref('#fff');
  const changeIconColor = () => {
    iconColor.value = iconColor.value === originalColor ? '#f00' : originalColor;
    
    };
    const changeIconColor2 = () => {
    iconColor2.value = iconColor2.value === originalColor ? ' #FFD700' : originalColor;
    
    };



    const showShare = ref(false);
    const options = [
      { name: '微信', icon: 'wechat' },
      { name: '微博', icon: 'weibo' },
      { name: '复制链接', icon: 'link' },
      { name: '分享海报', icon: 'poster' },
      { name: '二维码', icon: 'qrcode' },
    ];

    const onSelect = (option) => {
      showToast(option.name);
      showShare.value = false;
    };
    const defaultList = [
      { id: 100, text: '财' },
      { id: 101, text: '枫哥牛逼' },
      { id: 102, text: '弹幕1' },
      { id: 103, text: '弹幕2' },
      { id: 104, text: '弹幕3' },
      { id: 105, text: '财2' },
      { id: 106, text: '666' },
    ];

    const list = ref([...defaultList]);
    const currentVideoIndex = ref(0);
    const videos = [
      'http://localhost:9090/video/33.mp4',
      'http://localhost:9090/video/34.mp4',

      // 添加更多视频链接
    ];

    // const handleSwipe = (event) => {
    //   console.log("sb");
    //   console.log(event); 
    //   console.log(event.direction);
    //   if (event.direction === 'down') {
    //     currentVideoIndex.value = (currentVideoIndex.value + 1) % videos.length;
       
    //   }
    // };
    const onTouchStart = (event) => {
      // 记录触摸起始点的位置
      // event.touches[0].clientY 可以获取触摸点的Y坐标
      startY = event.touches[0].clientY;
   
    };

    const onTouchMove = (event) => {
      // 在滑动过程中处理滑动事件
      // event.touches[0].clientY 可以获取滑动点的Y坐标
      const currentY = event.touches[0].clientY;
  if (currentY > startY) {
    // 向下滑动
 

  } else if (currentY < startY) {
    // 向上滑动
    currentVideoIndex.value = (currentVideoIndex.value + 1) % videos.length;

  }
    };

    const show = ref(false);
    const showPopup = () => {
      show.value = true;
    };
    return{  currentVideoIndex,
      videos, iconColor2,
      list,
      iconColor,
        options,
      onSelect,
      showShare,changeIconColor,changeIconColor2,onTouchMove,onTouchStart,show,showPopup,comment
    }
}
}




</script>
<style lang="less" scoped>
.big{




    position: relative;
    height: 100%;
    width: 100%;
    background-color: black;
    .video-controls {
        height: 60px;
        width: 16px;
  position: absolute;
  flex-direction: column;
  top: 35%;
  right: 0;
  display: flex;
  background: rgba(255, 0, 0, 0);
  z-index: 2;
  .control-icon {
  margin: 4px 0; /* 上下间隔为 10px */
}
        
}
video::-webkit-media-controls-fullscreen-button {
display: none;
}
video::-webkit-media-controls-mute-button {
display: none;
}

.mpin{
  display: flex; 
  justify-content: center;
  font-size: large;

}


.mytu{
  display: flex;
   flex-flow:row;
   .nic{
    display: flex;
   flex-flow:column;
   margin-left: 4px;

   .myni{
    color: darkgray;
   }
 

   }
  



}
}


::v-deep .van-cell__title {
    flex: 3 ; /* 占比 3 */
}

::v-deep .van-cell__value {
    flex: 1 ; /* 占比 1 */
}
.kong{
  height: 60%;
}
.myvalue{
  height: 40%;
  display: flex;
  flex-direction: row; /* default value */
  justify-content: center; /* x-axis */
  align-items: baseline; /* y-axis */


.divaishu{
    margin-left: 4px;
  align-items: baseline;
  display: flex;
  flex-flow:row;


}

}










</style>