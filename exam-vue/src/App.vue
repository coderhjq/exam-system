<template>
  <router-view></router-view>
</template>

<script>

export default {
  name: 'app'
}
</script>

<style>
  @import './assets/css/global.css';
  /*脚部的样式*/
  .el-footer {
    text-align: center;
    height: 50px !important;
    background-color: white;
    opacity: 0.6;
  }
  ::-webkit-scrollbar {
    width: 8px;
  }
  /*滚动条的滑块*/
  ::-webkit-scrollbar-thumb {
    background-color: #eaecf1;
    border-radius: 3px;
  }
</style>
