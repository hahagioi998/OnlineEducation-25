<template>
    <div class="app-container">
        讲师表单
    <!--查询表单-->
    <!-- 表示这个查询在一行显示：inline -->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="teacherQuery.name" placeholder="讲师名"/>
      </el-form-item>

      <el-form-item>
        <el-select v-model="teacherQuery.level" clearable placeholder="讲师头衔">
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>

      <el-form-item label="添加时间">
        <el-date-picker
          v-model="teacherQuery.begin"
          type="datetime"
          placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="teacherQuery.end"
          type="datetime"
          placeholder="选择截止时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>

      <el-button type="primary" icon="el-icon-search" @click="getList()">查询</el-button>
      <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>

    <!-- 表格 -->
    <el-table
      :data="list"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (current - 1) * pageSize + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="name" label="名称" width="80" />

      <el-table-column label="头衔" width="80">
          <!-- 这个scope就是整个表格的意思，row就是得到每一行 -->
        <template slot-scope="scope">
          {{ scope.row.level===1?'高级讲师':'首席讲师' }}
        </template>
      </el-table-column>

      <el-table-column prop="intro" label="资历" />

      <el-table-column prop="gmtCreate" label="添加时间" width="160"/>

      <el-table-column prop="sort" label="排序" width="60" />

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
            <!-- 在页面中点击跳转路由的方法 -->
          <router-link :to="'/teacher/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

  <!-- 分页 -->
    <el-pagination
      :current-page="current"
      :page-size="pageSize"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="getList"
    />
    </div>
</template>

<script>
//引入调用teacher.js文件
import * as teacherF from '@/api/edu/teacher'
export default {
    //核心代码
    // data: {

    // },
    data() {//定义成变量和初始值
        return {
            list: null,//查询结果返回的一个list
            total: null,
            current: 1,
            pageSize: 5,
            //现在这个自定义类型中是没有属性，当条件查询时，上方的v-model会自动添加属性到这个类型中
            //现在可以不定义
            teacherQuery: {}//条件封装的对象
        }
    },
    created() {//页面渲染之前执行，一般调用methods定义的方法
        this.getList()
    },
    methods: {//创建具体的方法，调用teacher.js中定义的方法
        //讲师列表的方法，这个方法的方法名是自定义的
        //注意这个参数，是为了分页部分的调用，这个page=1是默认不传page的时候，page=1，如果传了
        //参数page = 全局page
        getList(current = 1){
            this.current = current
            teacherF.getTeacherListPage(this.current,this.pageSize,this.teacherQuery)
                .then(response => {
                    this.list = response.data.list
                    this.total = response.data.total
                })//请求成功
                .catch(error => {
                    alert(error)
                })//请求失败
        },

        //清空查询表单条件，重新查询所有
        resetData(){
            //因为之前已经用v-model双向绑定了所有属性和teacherQuery这个类型
            //所以只需要清空这个对象就可以了
            this.teacherQuery = {}
            this.getList()
            vm.$forceUpdate();
        },

        //逻辑删除，只是查不出来，其实还在库里
        removeDataById(id){
            this.$confirm('此操作将永久删除讲师记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {  //点击确定，执行then方法
                //调用删除的方法
                teacherF.deleteById(id)
                    .then(response =>{//删除成功
                    //提示信息
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    //回到列表页面
                    this.getList()
                })
            }) //点击取消，执行catch方法
            // teacherF.deleteById(id)
            // .then(response => {
            //     this.getList()
            // }).catch(error => {

            // })
            //注意这里的重新查看所有教师方法，因为axios是异步执行的
            //也就是说如果没有获得返回结果，也可能直接执行了getList方法
            //所以导致页面看起来没有变化，反映到数据库是先查再删
            //this.getList()
        }
    }
}
</script>