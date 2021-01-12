import request from '@/utils/request'

//新增小节
export function addVideo(video){
    return request({
        url: `/edu/videoService/addVideo`,
        method: 'post',
        data: video
    })
}

//删除小节
export function deleteVideo(id){
    return request({
        url: `/edu/videoService/deleteVideo?id=${id}`,
        method: 'delete'
    })
}

//根据id查询小节
export function getVideteoById(id){
    return request({
        url: `/edu/videoService/getVideteoById?id=${id}`,
        method: 'get'
    })
}

//根据id查询小节
export function updateVideo(video){
    return request({
        url: `/edu/videoService/updateVideo`,
        method: 'post',
        data: video
    })
}

//根据id删除视频
export function deleteVod(videoId){
    return request({
        url: `/videoService/deleteVod?videoIdList=${videoId}`,
        method: 'delete'
    })
}