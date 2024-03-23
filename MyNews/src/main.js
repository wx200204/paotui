import { createApp } from 'vue'
import App from './App.vue'
import "amfe-flexible/index.js"
import './assets/base.css'
import router from './router/index'
import 'vant/lib/index.css';
import { Tabbar, TabbarItem,Icon,ShareSheet,Uploader,Barrage,ActionSheet,Cell, CellGroup,Card,Tab, Tabs,Swipe, SwipeItem ,Search,
  NavBar,PullRefresh,showToast,Empty,ContactCard, Popup,Image as VanImage,Field ,Button,Picker,Toast} from 'vant';
import VueTouch from 'vue-touch';

const app = createApp(App);

// 手动设置视口大小
const setViewPort = () => {
    let deviceWidth = document.documentElement.clientWidth;
    if (deviceWidth > 750) deviceWidth = 750;
    document.documentElement.style.fontSize = deviceWidth / 7.5 + 'px';
  };
  
  setViewPort();
app.use(Tabbar).use(router).use(TabbarItem).use(Icon).use(ShareSheet).use(Barrage).use(VueTouch).use(Popup).use(Cell).use(CellGroup).use(VanImage)
.use(Card).use(Tab).use(Tabs).use(Swipe).use(SwipeItem).use(Search).use(NavBar).use(PullRefresh).use(showToast).use(Empty).use(ContactCard).use(ActionSheet)
.use(Uploader).use(Field).use(Button).use(Picker).use(Toast);
app.mount('#app')
