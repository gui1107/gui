<template>
  <div>
    <el-container style="min-height: 100vh;">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246);width: 13.5vw; overflow: hidden" >
        <el-menu style="min-height: 100vh; overflow: hidden"
                 active-text-color="#ffd04b"
                 :unique-opened="true"
                 router
        >
          <div style="height: 9vh; line-height: 60px; text-align: center">
            <img src="../assets/img/waflogo.png" alt="logo" style="width: 134px">
          </div>

          <el-menu-item index="/Home">
            <template slot="title">
              <i class="el-icon-cloudy"></i>
              Home
            </template>
          </el-menu-item>

          <el-menu-item>
            <template slot="title"><i class="el-icon-monitor"></i>Site Manager</template>
          </el-menu-item>

          <el-menu-item>
            <template slot="title"><i class="el-icon-place"></i>Ip Manage</template>
          </el-menu-item>

          <el-submenu index="rule">
            <template slot="title"><i class="el-icon-lock"></i>Rules</template>
            <el-menu-item index="/test">Post_Attack</el-menu-item>
            <el-menu-item index="4-2">Get_Attack</el-menu-item>
            <el-menu-item index="4-3">Url_Attack</el-menu-item>
            <el-menu-item index="4-4">Malicious_Scan_Attack</el-menu-item>
            <el-menu-item index="4-5">SQL_Injection_Attack</el-menu-item>
          </el-submenu>

          <el-menu-item>
            <template slot="title"><i class="el-icon-user"></i>User</template>
          </el-menu-item>
          <el-menu-item>
            <template slot="title"><i class="el-icon-wallet"></i>Waller</template>
          </el-menu-item>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid #ccc;height: 9vh;width: 86.5vw">
          <div style="padding-top: 10px;padding-left: 100px ">
            <el-dropdown>
              <el-avatar :size="40" icon="el-icon-user-solid"></el-avatar>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>ChangAccount</el-dropdown-item>
                <el-dropdown-item>

<!--            1.   tag 属性被弃用-->
<!--                  <router-link to="/login" tag="p">LoginOut</router-link>-->
<!--            2.    <router-link to="/login" custom v-slot="{ navigate }">-->
<!--                    <li @click="navigate" @keypress.enter="navigate" role="link">-->
<!--                      <a>LoginOut</a>-->
<!--                    </li>-->
<!--                  </router-link>-->

<!--                  因还需清理浏览器保持的用户信息，以上代码改进如下-->
                  <span style="text-decoration: none" @click="logout">LoginOut</span>
                </el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>

        </el-header>

        <el-main style="padding-top: 4vh; padding-left: 2vw">
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Manage",
  data() {
    return {
      timer: null
    }
  },
  created() {
    this.conflogin();
  },
  methods: {
    conflogin() {
      if(localStorage.getItem("user") == null){
        this.$router.push("/login")
        this.$message.success("请先登录")
      }
    },
    logout() {
      this.$router.push("/login")
      localStorage.removeItem("user")
      this.$message.success("退出成功")
    }
  }
}
</script>

<style scoped>
.el-header {
  /*background-color: #B3C0D1;*/
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>