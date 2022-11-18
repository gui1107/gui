<template>
  <div class="postrule">
    <el-button type="text" @click="open">点击打开 Message Box</el-button>
  </div>
</template>

<script>
export default {
  name: 'postrule',
  data: function() {
    return {

    }
  },
  methods: {
    open() {
      this.$prompt('请输入邮箱', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
        inputErrorMessage: '邮箱格式不正确'
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你的邮箱是: ' + value
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.postrule {
  /*box-sizing: border-box;*/
  /*width: 100vh;*/
  height: 85vh;
  width: 84vw;
  /*padding-top: 10%;*/
  /*background-color: #2fa8ec;*/
  background-image: url("../../assets/img/background.png");
  /*background-repeat: no-repeat;*/
  /*background-position: center right;*/
  /*background-size: 100%;*/
}

</style>