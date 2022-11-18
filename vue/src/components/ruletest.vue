<template>
  <div class="postrule">
    <div style="font-size: 24px">PostRule</div>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          label="ID"
          width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>

      <el-table-column
          label="RuleType"
          width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.ruleType }}</span>
        </template>
      </el-table-column>

      <el-table-column
          label="RuleItem"
          width="500">
        <template slot-scope="scope">
          <span>{{ scope.row.ruleItem }}</span>
        </template>
      </el-table-column>

      <el-table-column
          label="Mark"
         >
          <template slot-scope="scope">
          <span>{{ scope.row.mark }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Edit">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 15px">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[1,2,3,4,5,6,7,8,9,10]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      total: 0,
      pageSize: 10,
      pageNum: 1,
      form: {},
      dialogFormVisible: false
    }
  },
  created() {
    this.load()
  },
  methods:{
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    load(){
      this.request.get("page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        }
      }).then(res=>{
        if(res.code === "200"){
          this.tableData = res.data.data
          this.total = res.data.total
        }
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum;
      this.load()
    }
  }
}
</script>

<style scoped>
.postrule {
  height: 83vh;
  width: 82vw;
}

</style>