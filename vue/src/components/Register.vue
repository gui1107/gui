<template>
  <div class="login-wrap">
    <el-form class="login-container" :model="user" :rules="rules" ref="userForm">
      <div style="padding-left: 23%">
        <img src="../assets/img/waflogo.png" alt="logo" style="width: 140px">
      </div>
      <el-form-item prop="name">
        <el-input placeholder="请输入账号" size="medium"  prefix-icon="el-icon-user" v-model="user.name"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input placeholder="请输入密码" size="medium" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item prop="confirmed">
        <el-input placeholder="请确认密码" size="medium" prefix-icon="el-icon-lock" show-password v-model="user.confirmed"></el-input>
      </el-form-item>

        <el-button type="warning" size="medium" style="width: 50%; margin-left: 25%" @click="register">Sign In</el-button>
      <div style="width: 40%; text-align: center; margin-left: 30%; padding-top: 5px">
        <router-link to="/login"  style="font-size: 12px; color: #333">Back to Login</router-link>
      </div>
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
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 8, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 8, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur' }
        ],
        confirmed: [
          { required: true, message: '请确认密码', trigger: 'blur' },
          { min: 8, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    register() {
      // 表单规则验证
      this.$refs["userForm"].validate((valid) => {
        if (valid) {
          if(this.user.password !== this.user.confirmed){
            this.$message.error("两次输入密码不一致")
            return false;
          }
          // 向后端发送请求
          this.request.post("/user/register",this.user).then(res => {
            if(res.code === "200"){
              this.$router.push("/login")
              this.$message.success(("注册成功"))
            }else {

            }
          })
        } else {
          return false;
        }
      });

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login-wrap {
  width: 100vw;
  height: 100vh;
  padding-top: 12%;
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
}

</style>