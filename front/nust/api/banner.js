import request from '@/utils/request'

export function getListBanner(){
    return request({
        url: `/cms/Client/getAllBanner`,
        method: 'get'
    })
}