import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/company/list',
    method: 'get',
    params: query
  })
}

export function fetch() {
  return request({
    url: '/company/detail',
    method: 'get'
  })
}

export function create(data) {
  return request({
    url: '/company/create',
    method: 'post',
    data
  })
}

export function update(data) {
  return request({
    url: '/company/update',
    method: 'post',
    data
  })
}
