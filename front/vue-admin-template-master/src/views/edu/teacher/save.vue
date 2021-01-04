<template>
    <div class="app-container">
        讲师添加
        <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" controls-position="right" min=""/>
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
      <!-- 讲师头像 -->
      <el-form-item label="讲师头像">

          <!-- 头衔缩略图 -->
          <pan-thumb :image="teacher.avatar"/>
          <!-- 文件上传按钮 -->
          <el-button type="primary" icon="el-icon-upload" @click="imagecropperShow=true">更换头像
          </el-button>

          <!--
      v-show：是否显示上传组件
      :key：类似于id，如果一个页面多个图片上传控件，可以做区分
      :url：后台上传的url地址
      @close：关闭上传组件
      @crop-upload-success：上传成功后的回调 
        <input type="file" name="file"/>
      -->
          <image-cropper
                        v-show="imagecropperShow"
                        :width="300"
                        :height="300"
                        :key="imagecropperKey"
                        :url="BASE_API+'/fileOssService'"
                        field="file"
                        @close="close"
                        @crop-upload-success="cropSuccess"/>
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>
    </div>
</template>

<script>
import * as teacherF from '@/api/edu/teacher'
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'

export default {
    components: {ImageCropper, PanThumb},
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
            //上传组件弹框是否显示
            imagecropperShow: false,
            imagecropperKey: 0,
            //dev.js 中的Base-API，这个注意获取的方式
            BASE_API: process.env.BASE_API,
            saveBtnDisabled: false
        }
    },
    methods: {
        close() { //关闭上传弹框的方法
            this.imagecropperShow = false
            this.imagecropperKey = this.imagecropperKey + 1
        },
        cropSuccess(data) {//上传成功的方法
            this.teacher.avatar = data.result
            this.imagecropperShow = false
            this.imagecropperKey = this.imagecropperKey + 1
        },
        saveOrUpdate() {
            //根据id是否有值来判断到底应该修改还是更新
            if(this.teacher.id != null){
                this.updateTeacher(this.teacher)
            }else{
                this.insertTeacher(this.teacher)
            }
        },
        init() {
          //判断路径有id值,做修改
          if(this.$route.params && this.$route.params.id) {
              //从路径获取id值
              const id = this.$route.params.id
              //调用根据id查询的方法
              this.getInfo(id)
          } else { //路径没有id值，做添加
            //清空表单
            this.teacher = {}
          }
        },
        //添加讲师的方法
        insertTeacher(teacher) {
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
        getInfo(id) {
            teacherF.queryTById(id)
              .then(response => {
                  this.teacher = response.data.result
              }).catch(error => {

              })
        },
        //修改讲师的方法
        updateTeacher(teacher) {
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
    },
    created() { //页面渲染之前执行
      this.init()
    },
    watch: {  //监听
      $route(to, from) { //路由变化方式，路由发生变化，方法就会执行
        this.init()
      }
    },
}
</script>