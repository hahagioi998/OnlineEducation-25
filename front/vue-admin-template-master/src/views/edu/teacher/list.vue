<template>
    <div class="app-container">
        讲师表单
    </div>
</template>

<script>
//引入调用teacher.js文件
import teacher from '@/api/edu/teacher'
export default {
    //核心代码
    // data: {

    // },
    data() {//定义成变量和初始值
        return {
            list: null,//查询结果返回的一个list
            current: 1,
            pageSize: 5,
            teacherQuery: {}//条件封装的对象
        }
    },
    created() {//页面渲染之前执行，一般调用methods定义的方法
        this.getList()
        alert(111)
    },
    methods: {//创建具体的方法，调用teacher.js中定义的方法
        //讲师列表的方法，这个方法的方法名是自定义的
        getList(){
            teacher.getTeacherListPage(this.current,this.pageSize,this.teacherQuery)
                .then(response => {
                    console.log(response)
                    alert(response)
                })//请求成功
                .catch(error => {
                    alert(error)
                })//请求失败
        }
    }
}
</script>