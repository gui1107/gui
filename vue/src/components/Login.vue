<template>
  <div class="login-wrap">
    <el-form class="login-container" :model="user" :rules="rules" ref="userForm" @keyup.enter.native="login">
      <div style="padding-left: 23%">
        <img src="../assets/img/waflogo.png" alt="logo" style="width: 140px">
      </div>
      <el-form-item prop="name">
        <el-input size="medium" placeholder="请输入账号" prefix-icon="el-icon-user" v-model="user.name"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input size="medium" placeholder="请输入密码" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
      </el-form-item>

      <el-form-item >
        <el-button type="primary" size="medium" style="width: 30%;margin-left: 7%" @click="login" >Log In</el-button>
        <el-button type="warning" size="medium" style="width: 30%; margin-left: 26%" @click="register">Sign In</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

export default {
  name: 'login',
  data() {
    return {
      user: {},
      rules: {
        name: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 5, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 4, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur' }
        ],
      }
    }
  },
  methods: {
    login() {
      // 表单规则验证
      this.$refs["userForm"].validate((valid) => {
        if (valid) {
          // 向后端发送请求
          this.request.post("/user/login",this.user).then(res => {
            if(res.code === "200"){
              localStorage.setItem("user", JSON.stringify(res.data))  //存储用户信息到浏览器
              this.$router.push("/")
              this.$message.success(("登录成功"))
            }else {
              this.$message.error(res.msg)
            }
          })
        }
      });
    },
    register() {
      this.$router.push("/register")
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login-wrap {
  width: 100vw;
  height: 100vh;
  padding-top: 15%;
  background-image: url("../assets/img/background.png");
  background-repeat: no-repeat;
  background-position: center left;
  overflow: hidden;
}

.login-container {
  border-radius: 10px;
  margin: 0 auto;
  width: 350px;
  padding: 15px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  text-align: left;
  overflow: hidden
}

</style>