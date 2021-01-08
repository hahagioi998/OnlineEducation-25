import request from '@/utils/request'

//添加课程info
export function insertCourseInfo(courseInfo) {
    return request({
        url: `/edu/courseService/addCourseInfo`,
        method: 'post',
        data: courseInfo
        })
}

//根据课程id获取课程信息
export function getCourseInfoById(courseId) {
    return request({
        url: `/edu/courseService/getCourseInfoById?courseId=${courseId}`,
        method: 'get'
        })
}

//根据课程id更新课程信息
export function updateCourseInfoById(courseInfo) {
    return request({
        url: `/edu/courseService/updateCourseInfoById`,
        method: 'post',
        data: courseInfo
        })
}

//根据课程id查询课程及其他信息
export function getCouseInfoById(courseId) {
    return request({
        url: `/edu/courseService/getCouseInfoById?courseId=${courseId}`,
        method: 'get'
        })
}

//发布课程
export function goPublishCourse(courseId) {
    return request({
        url: `/edu/courseService/publishCourse?courseId=${courseId}`,
        method: 'post'
        })
}

//条件分页查询课程
export function getListCourse(current,size,course) {
    return request({
        url: `/edu/courseService/listCourseCondition?current=${current}&size=${size}`,
        method: 'post',
        data: course
        })
}

//删除课程
export function deleteCourse(courseId) {
    return request({
        url: `/edu/courseService/deleteCourse?courseId=${courseId}`,
        method: 'delete'
        })
}




