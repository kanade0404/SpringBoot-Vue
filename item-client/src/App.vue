<template>
  
  <el-container id="app">
    <el-header id="nav"><global-header/></el-header>
    <el-main><router-view></router-view></el-main>
  </el-container>
</template>

<script>
import GlobalHeader from './components/GlobalHeader'
export default {
  name: 'app',
  components: {
    GlobalHeader
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
