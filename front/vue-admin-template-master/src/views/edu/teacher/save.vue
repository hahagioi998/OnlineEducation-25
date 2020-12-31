<template>
    <div class="app-container">
        讲师添加
        <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" controls-position="right" min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level" clearable placeholder="请选择">
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career"/>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- 讲师头像：TODO -->

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>
    </div>
</template>

<script>
import * as teacherF from '@/api/edu/teacher'

export default {
    data(){
        return {
            teacher: {
                name: '',
                sort: 0,
                level: 1,
                career: '',
                intro: '',
                avatar: ''
            },
            saveBtnDisabled: false
        }
    },
    created(){
        //判断当前路径是否带了参数
        // if(this.$route.params && this.$route.params.id){
        //     const id = this.$route.params.id
        //     this.getInfo(id)
        // }else{
        //     //不带参数说明是新增讲师，以下的代码是有用的
        //     //但还是用了监听
        //     //this.teacher = {}
        // }
        init()

    },
    watch: {//监听
        $route(to, from){//当路径发生变化，这个监听就会生效
            init()
        }

    },
    methods: {
        init(){
            if(this.$route.params && this.$route.params.id){
            const id = this.$route.params.id
            this.getInfo(id)
            }else{
            //不带参数说明是新增讲师，以下的代码是有用的
            //但还是用了监听
            //this.teacher = {}
            }
        },
        saveOrUpdate(){
            //根据id是否有值来判断到底应该修改还是更新
            if(this.teacher.id != null){
                this.updateTeacher(this.teacher)
            }else{
                this.insertTeacher(this.teacher)
            }
        },
        //添加讲师的方法
        insertTeacher(teacher){
            teacherF.insertT(teacher)
              .then(response => {
                this.$message({
                    type: 'success',
                    message: '添加成功'
                })
                this.$router.push({path:'/teacher/list'})
            }).catch(error => {
                this.$message({
                    type: 'error',
                    message: '添加失败'
                })
            })
        },
        //根据id获取讲师信息
        getInfo(id){
            teacherF.queryTById(id)
              .then(response => {
                  this.teacher = response.data.result
              }).catch(error => {

              })
        },
        //修改讲师的方法
        updateTeacher(teacher){
            teacherF.updateTearcher(teacher)
              .then(reponse => {
                this.$message({
                    type: 'success',
                    message: '修改成功'
                })
                this.$router.push({path:'/teacher/list'})
              }).catch(error => {

              })
        }
    }
}
</script>