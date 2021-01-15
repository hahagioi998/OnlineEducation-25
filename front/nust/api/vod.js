import request from '@/utils/request'

export function getPlayAuth (videoId)  {
    return request({
      url: `/videoService/getAuthById?videoId=${videoId}`,
      method: 'get'
    })
}