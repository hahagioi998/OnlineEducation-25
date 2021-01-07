//新增小节
export function addVideo(id){
    return request({
        url: `/edu/teacherService/deleteById/${id}`,
        method: 'delete'
    })
}

//删除小节
export function deleteVideo(id){
    return request({
        url: `/edu/teacherService/deleteById/${id}`,
        method: 'delete'
    })
}