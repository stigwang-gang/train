<template>
  <a-layout id="components-layout-demo-top-side-2">
    <the-header-view></the-header-view>
    <a-layout>
      <the-sider-view></the-sider-view>
      <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
      >
<!--        根据子路由动态生成-->
        <router-view></router-view>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script>
import { defineComponent } from 'vue';
import TheHeaderView from "@/components/the-header";
import TheSiderView from "@/components/the-sider";
// import axios from "axios";
// import {notification} from "ant-design-vue";
// import store from "@/store";
export default defineComponent({
    name:"main-view",
     components: {
      TheSiderView,
      TheHeaderView,
        },
  setup() {
    // const count = ref(0);
    // axios.get("/member/member/count").then((response) => {
    //   let data = response.data;
    //   if (data.success) {
    //     count.value = data.content;
    //   } else {
    //     notification.error({ description: data.message });
    //   }
    // });
 return {
   // count
     };
    },
});
</script>
<style>
#components-layout-demo-top-side-2 .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side-2 .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>
