import request from '@/utils/request'

//讲师列表分页查询
export function getTeacherListPage(current,pageSize,teacherQuery) {
    //1 讲师列表（条件查询分页）
    //current当前页 limit每页记录数 teacherQuery条件对象
    return request({
        //url: '/eduservice/teacher/pageTeacherCondition/'+current+"/"+limit,
        url: `/teacherService/selectTPageParam/${current}/${pageSize}`,
        method: 'post',
        //teacherQuery条件对象，后端使用RequestBody获取数据
        //data表示把对象转换json进行传递到接口里面
        data: teacherQuery
        })
}

//逻辑删除讲师
export function deleteById(id){
    return request({
        url: `/teacherService/deleteById/${id}`,
        method: 'delete'
    })
}

//添加讲师
export function insertT(teacher){
    return request({
        url: `/teacherService/insertT`,
        method: 'post',
        data: teacher
    })
}

//根据id查询讲师
export function queryTById(id){
    return request({
        url: `/teacherService/queryTById?teacherId=${id}`,
        method: 'get'
    })
}

//根据id更新讲师
export function updateTearcher(teacher){
    return request({
        url: `/teacherService/updateTearcher`,
        method: 'post',
        data: teacher
    })
}
